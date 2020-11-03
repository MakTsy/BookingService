package com.booking.demo.services;


import com.booking.demo.entities.Ticket;
import com.booking.demo.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class BookingService {
    public final TicketRepository ticketRepository;

    @Autowired
    public BookingService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    @Transactional
    public UUID bookTicket(Ticket ticket) {
        this.ticketRepository.save(ticket);
        return ticket.getIdTicket();
    }

    @Transactional
    public Ticket getTicket(UUID id) {
        return this.ticketRepository.findById(id).orElseThrow();
    }

}
