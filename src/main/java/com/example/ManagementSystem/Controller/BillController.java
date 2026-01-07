package com.example.ManagementSystem.Controller;

import com.example.ManagementSystem.Dto.BIllsDto.BillRequest;
import com.example.ManagementSystem.Entity.Bill;
import com.example.ManagementSystem.Service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    @PostMapping
    public ResponseEntity<Bill> generateBill(@RequestBody BillRequest billRequest){
        Bill generateBill = billService.generateBill(billRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(generateBill);
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills(){
        List<Bill> billList = billService.getALlBills();
        return ResponseEntity.status(HttpStatus.OK).body(billList);
    }

    @GetMapping("/{billId}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long billId){
        Bill bill = billService.getBill(billId);
        return ResponseEntity.status(HttpStatus.OK).body(bill);
    }
}
