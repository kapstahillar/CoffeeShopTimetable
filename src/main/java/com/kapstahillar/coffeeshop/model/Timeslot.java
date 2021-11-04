package com.kapstahillar.coffeeshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.LinkedHashSet;


@Entity
@Table(name = "timeslot")
public class Timeslot {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "timeslot_customer",
            joinColumns = @JoinColumn(name = "timeslot_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Collection<Customer> customers = new LinkedHashSet<Customer>();

    // Name of a timeslot
    @Column
    @NotEmpty
    private String name;

    // Don't allow public initialisation without parameters
    protected Timeslot() {}

    public Timeslot(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Customer> getBookedCustomers() {
        return customers;
    }

    // Added this for testing purposes
    @Override
    public String toString() {
        return String.format("Customer[id=%d]", id);
    }
}
