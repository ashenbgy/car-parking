package com.test.carparkinginvoicing.service.serviceImpl;

import com.test.carparkinginvoicing.dto.SeasonalDiscountDto;
import com.test.carparkinginvoicing.entity.SeasonalDiscount;
import com.test.carparkinginvoicing.repository.SeasonalDiscountRepository;
import com.test.carparkinginvoicing.service.SeasonalDiscountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonalDiscountServiceImpl implements SeasonalDiscountService {
    @Autowired
    private SeasonalDiscountRepository seasonalDiscountRepository;

    @Override
    public List<SeasonalDiscount> getAllDiscounts() {
        return seasonalDiscountRepository.findAll();
    }

    @Override
    public Optional<SeasonalDiscount> getDiscountById(Long id) {
        return seasonalDiscountRepository.findById(id);
    }

    @Override
    public SeasonalDiscount saveDiscount(SeasonalDiscountDto discountDto) {
        SeasonalDiscount discount = new SeasonalDiscount();
        discount.setDiscountName(discountDto.getDiscountName());
        discount.setDiscountPercentage(discountDto.getDiscountPercentage());
        discount.setStartDate(discountDto.getStartDate());
        discount.setEndDate(discountDto.getEndDate());

        return seasonalDiscountRepository.save(discount);
    }

    @Override
    public SeasonalDiscount updateDiscount(Long id, SeasonalDiscountDto discountDTO) {
        SeasonalDiscount existingDiscount = seasonalDiscountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Discount not found"));

        existingDiscount.setDiscountName(discountDTO.getDiscountName());
        existingDiscount.setDiscountPercentage(discountDTO.getDiscountPercentage());
        existingDiscount.setStartDate(discountDTO.getStartDate());
        existingDiscount.setEndDate(discountDTO.getEndDate());

        return seasonalDiscountRepository.save(existingDiscount);
    }

    @Override
    public void deleteDiscount(Long id) {
        seasonalDiscountRepository.deleteById(id);
    }
}
