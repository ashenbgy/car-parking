package com.test.carparkinginvoicing.service.serviceImpl;

import com.test.carparkinginvoicing.dto.ParkingInvoiceDto;
import com.test.carparkinginvoicing.entity.ParkingInvoice;
import com.test.carparkinginvoicing.entity.SeasonalDiscount;
import com.test.carparkinginvoicing.entity.User;
import com.test.carparkinginvoicing.entity.VehicleCategory;
import com.test.carparkinginvoicing.repository.ParkingInvoiceRepository;
import com.test.carparkinginvoicing.repository.SeasonalDiscountRepository;
import com.test.carparkinginvoicing.repository.UserRepository;
import com.test.carparkinginvoicing.repository.VehicleCategoryRepository;
import com.test.carparkinginvoicing.service.ParkingInvoiceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParkingInvoiceServiceImpl implements ParkingInvoiceService {
    @Autowired
    private ParkingInvoiceRepository parkingInvoiceRepository;

    @Autowired
    private VehicleCategoryRepository vehicleCategoryRepository;

    @Autowired
    private SeasonalDiscountRepository seasonalDiscountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ParkingInvoice> getAllInvoices() {
        return parkingInvoiceRepository.findAll();
    }

    @Override
    public ParkingInvoice getInvoiceById(Long id) {
        return parkingInvoiceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
    }

    @Override
    public ParkingInvoice createInvoice(ParkingInvoiceDto invoiceDto) {
        User user = userRepository.findById(invoiceDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        VehicleCategory category = vehicleCategoryRepository.findById(invoiceDto.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle category not found"));

        SeasonalDiscount discount = seasonalDiscountRepository.findById(invoiceDto.getDiscountId())
                .orElseThrow(() -> new EntityNotFoundException("Seasonal Discount not found"));

        BigDecimal basePrice = category.getPricePerHour().multiply(BigDecimal.valueOf(invoiceDto.getParkingDuration()));
        BigDecimal discountAmount = (discount != null) ? basePrice.multiply(discount.getDiscountPercentage().divide(BigDecimal.valueOf(100))) : BigDecimal.ZERO;
        BigDecimal totalAmount = basePrice.subtract(discountAmount);

        ParkingInvoice invoice = new ParkingInvoice();
        invoice.setUser(user);
        invoice.setCategory(category);
        invoice.setSeasonalDiscount(discount);

        invoice.setParkingDuration(invoiceDto.getParkingDuration());
        invoice.setBasePrice(basePrice);
        invoice.setDiscountApplied(discountAmount);
        invoice.setTotalAmount(totalAmount);
        invoice.setCreatedAt(LocalDateTime.now());

        return parkingInvoiceRepository.save(invoice);
    }

    @Override
    public ParkingInvoice updateInvoice(Long id, ParkingInvoiceDto invoiceDTO) {
        ParkingInvoice existingInvoice = parkingInvoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));

        User user = userRepository.findById(invoiceDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        VehicleCategory category = vehicleCategoryRepository.findById(invoiceDTO.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle category not found"));

        SeasonalDiscount discount = null;
        if (invoiceDTO.getDiscountId() != null) {
            discount = seasonalDiscountRepository.findById(invoiceDTO.getDiscountId())
                    .orElseThrow(() -> new EntityNotFoundException("Seasonal Discount not found"));
        }

        existingInvoice.setUser(user);
        existingInvoice.setCategory(category);
        existingInvoice.setSeasonalDiscount(discount);
        existingInvoice.setParkingDuration(invoiceDTO.getParkingDuration());

        BigDecimal basePrice = category.getPricePerHour().multiply(BigDecimal.valueOf(invoiceDTO.getParkingDuration()));
        BigDecimal discountAmount = (discount != null) ? basePrice.multiply(discount.getDiscountPercentage().divide(BigDecimal.valueOf(100))) : BigDecimal.ZERO;
        BigDecimal totalAmount = basePrice.subtract(discountAmount);

        existingInvoice.setBasePrice(basePrice);
        existingInvoice.setDiscountApplied(discountAmount);
        existingInvoice.setTotalAmount(totalAmount);

        return parkingInvoiceRepository.save(existingInvoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        parkingInvoiceRepository.deleteById(id);
    }


}
