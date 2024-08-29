package com.test.carparkinginvoicing.service.serviceImpl;

import com.test.carparkinginvoicing.dto.VehicleCategoryDto;
import com.test.carparkinginvoicing.entity.VehicleCategory;
import com.test.carparkinginvoicing.repository.VehicleCategoryRepository;
import com.test.carparkinginvoicing.service.VehicleCategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService {
    @Autowired
    private VehicleCategoryRepository vehicleCategoryRepository;

    @Override
    public List<VehicleCategory> getAllCategories() {
        return vehicleCategoryRepository.findAll();
    }

    @Override
    public VehicleCategory getCategoryById(Long id) {
        return vehicleCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle category not found"));
    }

    @Override
    public VehicleCategory saveCategory(VehicleCategoryDto categoryDto) {
        VehicleCategory category = new VehicleCategory();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setPricePerHour(categoryDto.getPricePerHour());

        return vehicleCategoryRepository.save(category);
    }

    @Override
    public VehicleCategory updateCategory(Long id, VehicleCategoryDto categoryDTO) {
        VehicleCategory existingCategory = vehicleCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        existingCategory.setCategoryName(categoryDTO.getCategoryName());
        existingCategory.setPricePerHour(categoryDTO.getPricePerHour());

        return vehicleCategoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        vehicleCategoryRepository.deleteById(id);
    }
}
