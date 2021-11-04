package com.kapstahillar.coffeeshop.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;

// Customer model
// Defines a customer that can a book timeslot
// In test assignment no other info than ID is required
// for customer.
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(mappedBy = "customers")
    private final Collection<Timeslot> timeslots = new LinkedHashSet<Timeslot>();

    public Long getId() {
        return id;
    }

    // Gets all timeslots for current customer.
    public Collection<Timeslot> getBookedTimeslots() {
        return timeslots;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d]", id);
    }
}
