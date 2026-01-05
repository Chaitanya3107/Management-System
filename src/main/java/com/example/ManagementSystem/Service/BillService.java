package com.example.ManagementSystem.Service;

import com.example.ManagementSystem.Dto.BIllsDto.BillItemRequest;
import com.example.ManagementSystem.Dto.BIllsDto.BillRequest;
import com.example.ManagementSystem.Entity.Bill;
import com.example.ManagementSystem.Entity.Parts;
import com.example.ManagementSystem.Entity.SaleItems;
import com.example.ManagementSystem.Repository.BillRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BillService {

    private final BillRepository billRepository;
    private final PartsService partsService;


    public Bill generateBill(BillRequest request){
        // create a new bill
        Bill bill = new Bill();
        BigDecimal totalPrice = BigDecimal.ZERO;
        List<SaleItems> saleItemsList = new ArrayList<>();

        // iterate through bill request list
        for(BillItemRequest itemDto: request.getItems()){
            // getting original part
            Parts part = partsService.getPartById(itemDto.getPartId());
            // remove quantity form actual stock
            partsService.removePart(itemDto.getPartId(), itemDto.getQuantity());
            // create saleItem obj
            SaleItems saleItem = new SaleItems();
            saleItem.setBill(bill);
            saleItem.setParts(part);
            saleItem.setSellingPrice(part.getSellingPrice());
            saleItem.setQuantity(itemDto.getQuantity());
            BigDecimal price = part.getSellingPrice().multiply(BigDecimal.valueOf(itemDto.getQuantity()));
            totalPrice = totalPrice.add(price);
            saleItemsList.add(saleItem);
        }
        bill.setTotalPrice(totalPrice);
        bill.setSaleItems(saleItemsList);
        billRepository.save(bill);
        return bill;
    }

    public List<Bill> getALlBills(){
        return billRepository.findAll();
    }


    public Bill getBill(Long billId) {
        return billRepository.findById(billId).orElseThrow(()->new RuntimeException("Bill not found!"));
    }
}













