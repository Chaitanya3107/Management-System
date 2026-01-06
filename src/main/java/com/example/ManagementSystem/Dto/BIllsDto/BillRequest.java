package com.example.ManagementSystem.Dto.BIllsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillRequest {
    List<BillItemRequest> items;
}
