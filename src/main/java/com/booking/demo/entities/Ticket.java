package com.booking.demo.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTicket;
    private UUID idClient;
    private UUID idFlight;
    private String sitClass;
    boolean payed;

    public Ticket(UUID idClient, UUID idFlight, String sitClass) {
        this.idClient = idClient;
        this.idFlight = idFlight;
        this.sitClass = sitClass;
        this.payed = false;
    }
    public Ticket() {
    }

    public UUID getIdTicket() {
        return this.idTicket;
    }

    public String getSitClass() {
        return this.sitClass;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public UUID getClientId() {
        return this.idClient;
    }

    /*public Client getClient() {
        return this.client;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public boolean isPayed() {
        return this.payed;
    }*/
}
