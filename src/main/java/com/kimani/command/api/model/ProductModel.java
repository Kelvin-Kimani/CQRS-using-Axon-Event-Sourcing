package com.kimani.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductModel {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
