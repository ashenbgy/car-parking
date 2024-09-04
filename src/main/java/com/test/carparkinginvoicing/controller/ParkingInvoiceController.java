package com.test.carparkinginvoicing.controller;

import com.test.carparkinginvoicing.dto.ParkingInvoiceDto;
import com.test.carparkinginvoicing.entity.ParkingInvoice;
import com.test.carparkinginvoicing.service.ParkingInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "*")
public class ParkingInvoiceController {
    @Autowired
    private ParkingInvoiceService parkingInvoiceService;

    @GetMapping
    public ResponseEntity<List<ParkingInvoice>> getAllInvoices() {
        List<ParkingInvoice> invoices = parkingInvoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingInvoice> getInvoiceById(@PathVariable Long id) {
        ParkingInvoice invoice = parkingInvoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    @PostMapping
    public ResponseEntity<ParkingInvoice> createInvoice(@RequestBody ParkingInvoiceDto invoiceDTO) {
        ParkingInvoice createdInvoice = parkingInvoiceService.createInvoice(invoiceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingInvoice> updateInvoice(@PathVariable Long id, @RequestBody ParkingInvoiceDto invoiceDTO) {
        ParkingInvoice updatedInvoice = parkingInvoiceService.updateInvoice(id, invoiceDTO);
        return ResponseEntity.ok(updatedInvoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        parkingInvoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}
