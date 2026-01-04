package com.example.ManagementSystem.Entity;

import ch.qos.logback.core.model.INamedModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sale_items")
public class SaleItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonIgnore // use to break recursive call, add later
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "parts_id")
    private Parts parts;

    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal sellingPrice;

}
