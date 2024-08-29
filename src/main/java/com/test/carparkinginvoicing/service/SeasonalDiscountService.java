package com.test.carparkinginvoicing.service;

import com.test.carparkinginvoicing.dto.SeasonalDiscountDto;
import com.test.carparkinginvoicing.entity.SeasonalDiscount;

import java.util.List;
import java.util.Optional;

public interface SeasonalDiscountService {
    List<SeasonalDiscount> getAllDiscounts();

    Optional<SeasonalDiscount> getDiscountById(Long id);

    SeasonalDiscount saveDiscount(SeasonalDiscountDto discountDto);

    SeasonalDiscount updateDiscount(Long id, SeasonalDiscountDto discountDTO);

    void deleteDiscount(Long id);
}
