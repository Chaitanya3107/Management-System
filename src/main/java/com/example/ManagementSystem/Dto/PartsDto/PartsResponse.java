package com.example.ManagementSystem.Dto.PartsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartsResponse {
    private String name;
    private BigDecimal sellingPrice;
    private Integer stockQuantity;
}
