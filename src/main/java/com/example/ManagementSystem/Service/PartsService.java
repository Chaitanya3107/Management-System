package com.example.ManagementSystem.Service;

import com.example.ManagementSystem.Dto.PartsDto.PartsResponse;
import com.example.ManagementSystem.Entity.Parts;
import com.example.ManagementSystem.Repository.PartsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PartsService {

    private final PartsRepository partsRepository;

    // add parts, with initial quantity
    public Parts addParts(Parts parts){
        return partsRepository.save(parts);
    }

    // get all parts
    public List<Parts> getAllParts(){
        List<Parts> partsList = partsRepository.findAllByOrderByIdAsc();
        return partsList;
    }

    // get part by id
    public Parts getPartById(Long partId){
        return partsRepository.findById(partId).orElseThrow(() -> new RuntimeException("Part not found"));
    }

    // remove part , reduce quantity
    public void removePart(Long partId, Integer quantity){
        Parts parts = partsRepository.findById(partId).orElseThrow(() -> new RuntimeException("No Part found"));

        if(parts.getStockQuantity()<quantity){
            throw new RuntimeException("Insufficient quantity");
        }

        parts.setStockQuantity(parts.getStockQuantity()-quantity);
        partsRepository.save(parts);
    }

    // update part name
    public PartsResponse updateName(Long partId,String name){
        Parts part = partsRepository.findById(partId).orElseThrow(()-> new RuntimeException("Part not found"));
        part.setName(name);
        partsRepository.save(part);
        PartsResponse updatedPart = new PartsResponse(part.getName(),part.getBrand(),part.getSellingPrice(),part.getStockQuantity());
        return updatedPart;
    }

    // update part quantity
    public PartsResponse updateQuantity(Long partId, Integer quantity){
        Parts part = partsRepository.findById(partId).orElseThrow(()-> new RuntimeException("Part not found"));
        part.setStockQuantity(part.getStockQuantity() + quantity);
        partsRepository.save(part);
        PartsResponse updatedPart = new PartsResponse(part.getName(),part.getBrand(),part.getSellingPrice(),part.getStockQuantity());
        return updatedPart;
    }

    // update part selling price
    public PartsResponse updateSellingPrice(Long partId, BigDecimal sellingPrice){
        Parts part = partsRepository.findById(partId).orElseThrow(()-> new RuntimeException("Part not found"));
        part.setSellingPrice(sellingPrice);
        partsRepository.save(part);
        PartsResponse updatedPart = new PartsResponse(part.getName(),part.getBrand(),part.getSellingPrice(),part.getStockQuantity());
        return updatedPart;
    }

    // update part brand
    public PartsResponse updateBrand(Long partId,String brand){
        Parts part = partsRepository.findById(partId).orElseThrow(()-> new RuntimeException("Part not found"));
        part.setBrand(brand);
        partsRepository.save(part);
        PartsResponse updatedPart = new PartsResponse(part.getName(),part.getBrand(),part.getSellingPrice(),part.getStockQuantity());
        return updatedPart;
    }

    public void deletePart(Long partId){
        partsRepository.deleteById(partId);
    }

}
















