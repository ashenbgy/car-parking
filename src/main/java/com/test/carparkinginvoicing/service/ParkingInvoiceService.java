package com.test.carparkinginvoicing.service;

import com.test.carparkinginvoicing.dto.ParkingInvoiceDto;
import com.test.carparkinginvoicing.entity.ParkingInvoice;

import java.util.List;

public interface ParkingInvoiceService {
    List<ParkingInvoice> getAllInvoices();

    ParkingInvoice getInvoiceById(Long id);

    ParkingInvoice createInvoice(ParkingInvoiceDto invoice);

    ParkingInvoice updateInvoice(Long id, ParkingInvoiceDto invoiceDTO);

    void deleteInvoice(Long id);
}
