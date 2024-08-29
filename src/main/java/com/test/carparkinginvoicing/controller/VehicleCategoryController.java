package com.test.carparkinginvoicing.controller;

import com.test.carparkinginvoicing.dto.VehicleCategoryDto;
import com.test.carparkinginvoicing.entity.VehicleCategory;
import com.test.carparkinginvoicing.service.VehicleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "*")
public class VehicleCategoryController {
    @Autowired
    private VehicleCategoryService vehicleCategoryService;

    @GetMapping
    public ResponseEntity<List<VehicleCategory>> getAllCategories() {
        List<VehicleCategory> categories = vehicleCategoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleCategory> getCategoryById(@PathVariable Long id) {
        VehicleCategory category = vehicleCategoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<VehicleCategory> createCategory(@RequestBody VehicleCategoryDto categoryDto) {
        VehicleCategory savedCategory = vehicleCategoryService.saveCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleCategory> updateCategory(@PathVariable Long id, @RequestBody VehicleCategoryDto categoryDTO) {
        VehicleCategory updatedCategory = vehicleCategoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        vehicleCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
