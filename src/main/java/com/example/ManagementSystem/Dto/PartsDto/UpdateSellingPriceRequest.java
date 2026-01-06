package com.example.ManagementSystem.Dto.PartsDto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateSellingPriceRequest {
    private BigDecimal sellingPrice;
}
