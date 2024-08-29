package com.test.carparkinginvoicing.repository;

import com.test.carparkinginvoicing.entity.ParkingInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingInvoiceRepository extends JpaRepository<ParkingInvoice, Long> {
}
