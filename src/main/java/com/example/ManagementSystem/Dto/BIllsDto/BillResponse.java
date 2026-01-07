package com.example.ManagementSystem.Dto.BIllsDto;

import com.example.ManagementSystem.Entity.SaleItems;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillResponse {

    private LocalDateTime billDate = LocalDateTime.now();
    private BigDecimal totalPrice;
    private List<SaleItems> saleItems;
}
