package com.example.ManagementSystem.Controller;

import com.example.ManagementSystem.Dto.PartsDto.*;
import com.example.ManagementSystem.Entity.Parts;
import com.example.ManagementSystem.Service.PartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parts")
//@CrossOrigin(origins = "*")  // need to add this later
public class PartsController {

    private final PartsService partsService;

    @PostMapping
    public ResponseEntity<Parts> createPart(@RequestBody Parts parts){
        Parts savedPart = partsService.addParts(parts);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPart);
    }
    @GetMapping
    public ResponseEntity<List<Parts>> getAllParts(){
        List<Parts> allPartsList = partsService.getAllParts();
        return ResponseEntity.status(HttpStatus.OK).body(allPartsList);
    }

    @GetMapping("/{partId}")
    public ResponseEntity<Parts> getPart(@PathVariable Long partId){
        Parts savedPart = partsService.getPartById(partId);
        return ResponseEntity.status(HttpStatus.OK).body(savedPart);
    }

    @PostMapping("/removeParts/{partId}")
    public ResponseEntity<?> removePart(@PathVariable Long partId,@RequestBody RemovePartsRequest removePartsRequest){
        partsService.removePart(partId, removePartsRequest.getQuantity());
        return ResponseEntity.ok("Quantity Reduced");
    }
//    @PatchMapping("/{partId}/name")
//    public ResponseEntity<PartsResponse> updateName(@PathVariable Long partId, @RequestBody UpdateNameRequest updatedName){
//        PartsResponse updated = partsService.updateName(partId, updatedName.getName());
//        return ResponseEntity.ok(updated);
//    }
//
//    @PatchMapping("/{partId}/quantity")
//    public ResponseEntity<PartsResponse> updateQuantity(@PathVariable Long partId, @RequestBody UpdateQuantityRequest updateQuantity){
//        PartsResponse updated = partsService.updateQuantity(partId, updateQuantity.getQuantity());
//        return ResponseEntity.ok(updated);
//    }
//
//    @PatchMapping("/{partId}/sellingPrice")
//    public ResponseEntity<PartsResponse> updateSellingPrice(@PathVariable Long partId, @RequestBody UpdateSellingPriceRequest updatedSellingPrice){
//        PartsResponse updated = partsService.updateSellingPrice(partId, updatedSellingPrice.getSellingPrice());
//        return ResponseEntity.ok(updated);
//    }
//
//    @DeleteMapping("/{partId}")
//    public ResponseEntity<?> deletePart(@PathVariable Long partId){
//         partsService.deletePart(partId);
//         return ResponseEntity.ok("Deleted");
//    }





}
