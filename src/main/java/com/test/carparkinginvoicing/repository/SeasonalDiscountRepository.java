package com.test.carparkinginvoicing.repository;

import com.test.carparkinginvoicing.entity.SeasonalDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonalDiscountRepository extends JpaRepository<SeasonalDiscount, Long> {
}
