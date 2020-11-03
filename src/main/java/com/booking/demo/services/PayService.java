package com.booking.demo.services;

import com.booking.demo.entities.Ticket;
import com.booking.demo.repo.TicketRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PayService {
    private final TicketRepository ticketRepository;

    public PayService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public void pay(Ticket ticket) {
        ticket.setPayed(true);
        this.ticketRepository.save(ticket);
    }

}
