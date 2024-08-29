package com.test.carparkinginvoicing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ParkingInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private VehicleCategory category;
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private SeasonalDiscount seasonalDiscount;
    private Long parkingDuration;
    private BigDecimal basePrice;
    private BigDecimal discountApplied;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
}
