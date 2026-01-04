package com.example.ManagementSystem.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime billDate = LocalDateTime.now();

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<SaleItems> saleItems;



}
