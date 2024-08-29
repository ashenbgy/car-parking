package com.test.carparkinginvoicing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingInvoiceDto {
    private Long invoiceId;
    private Long userId;
    private Long categoryId;
    private Long discountId;
    private Long parkingDuration;
}
