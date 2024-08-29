package com.test.carparkinginvoicing.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VehicleCategoryDto {
    private Long categoryId;
    private String categoryName;
    private BigDecimal pricePerHour;
}
