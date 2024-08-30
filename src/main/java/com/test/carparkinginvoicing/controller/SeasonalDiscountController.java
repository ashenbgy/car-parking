package com.test.carparkinginvoicing.controller;

import com.test.carparkinginvoicing.dto.SeasonalDiscountDto;
import com.test.carparkinginvoicing.entity.SeasonalDiscount;
import com.test.carparkinginvoicing.service.SeasonalDiscountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/discounts")
@CrossOrigin(origins = "*")
public class SeasonalDiscountController {
    @Autowired
    private SeasonalDiscountService seasonalDiscountService;

    @GetMapping
    public ResponseEntity<List<SeasonalDiscount>> getAllDiscounts() {
        List<SeasonalDiscount> discounts = seasonalDiscountService.getAllDiscounts();
        return ResponseEntity.ok(discounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeasonalDiscount> getDiscountById(@PathVariable Long id) {
        SeasonalDiscount discount = seasonalDiscountService.getDiscountById(id)
                .orElseThrow(() -> new EntityNotFoundException("Discount not found"));;
        return ResponseEntity.ok(discount);
    }

    @PostMapping
    public ResponseEntity<SeasonalDiscount> createDiscount(@RequestBody SeasonalDiscountDto discountDTO) {
        SeasonalDiscount savedDiscount = seasonalDiscountService.saveDiscount(discountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDiscount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeasonalDiscount> updateDiscount(@PathVariable Long id, @RequestBody SeasonalDiscountDto discountDTO) {
        SeasonalDiscount updatedDiscount = seasonalDiscountService.updateDiscount(id, discountDTO);
        return ResponseEntity.ok(updatedDiscount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
        seasonalDiscountService.deleteDiscount(id);
        return ResponseEntity.noContent().build();
    }
}
