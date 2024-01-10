package com.inodinln.generativeAiTask1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer quantity;

    public ItemEntity(String name, String description, BigDecimal price, Integer quantity){
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

}
