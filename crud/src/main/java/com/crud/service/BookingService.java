package com.crud.service;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Entity.CrudEntity;
import com.crud.repository.CrudRepository;
import com.crud.utils.PdfGenerator;

@Service
public class BookingService {

	    @Autowired
	    private CrudRepository crudRepository;

	    public ByteArrayInputStream generateTicketPdf(Long id) {
	        CrudEntity entity = crudRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Booking not found"));
	        return PdfGenerator.bookingTicketPdf(entity);
	    }
	}
