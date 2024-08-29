package com.test.carparkinginvoicing.service;

import com.test.carparkinginvoicing.dto.VehicleCategoryDto;
import com.test.carparkinginvoicing.entity.VehicleCategory;

import java.util.List;

public interface VehicleCategoryService {
    List<VehicleCategory> getAllCategories();

    VehicleCategory getCategoryById(Long id);

    VehicleCategory saveCategory(VehicleCategoryDto categoryDto);

    void deleteCategory(Long id);

    VehicleCategory updateCategory(Long id, VehicleCategoryDto categoryDTO);
}
