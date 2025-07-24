package com.crud.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.crud.service.BookingService;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;

	@GetMapping("/booking/{id}/ticket")
	public ResponseEntity<byte[]> downloadTicket(@PathVariable Long id) throws IOException {
		
	    ByteArrayInputStream bis = bookingService.generateTicketPdf(id);

	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "inline; filename=ticket_" + id + ".pdf");

	    return ResponseEntity
	            .ok()
	            .headers(headers)
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(bis.readAllBytes());
	}

}
