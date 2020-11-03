package com.booking.demo.controllers;

import com.booking.demo.entities.Ticket;
import com.booking.demo.entities.dto.TicketDTO;
import com.booking.demo.services.BookingService;
import com.booking.demo.services.PayService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class BookingController {
    private final BookingService bookingService;
    private final PayService payService;

    @Autowired
    public BookingController(BookingService bookingService, PayService payService) {
        this.bookingService = bookingService;
        this.payService = payService;
    }

    @RequestMapping(value="book",method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public ResponseEntity<String> bookTicket(@RequestBody String delJson) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        TicketDTO ticketDTO = gson.fromJson(delJson, TicketDTO.class);
        UUID id = this.bookingService.bookTicket(new Ticket(ticketDTO.clientId,ticketDTO.flightId,ticketDTO.sitClass));
        this.payService.pay(this.bookingService.getTicket(id));
        return new ResponseEntity<String>(String.valueOf(id),HttpStatus.OK);
    }

    @RequestMapping(value="getTicket",method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getTicket(@RequestParam("idTicket") UUID idTicket) {
        Gson json = new Gson();
        String ticket = json.toJson(this.bookingService.getTicket(idTicket));
        return new ResponseEntity<String>(ticket,HttpStatus.OK);
    }



}
