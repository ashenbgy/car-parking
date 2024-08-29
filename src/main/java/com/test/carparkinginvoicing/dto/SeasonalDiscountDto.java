package com.test.carparkinginvoicing.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SeasonalDiscountDto {
    private Long discountId;
    private String discountName;
    private BigDecimal discountPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
}
