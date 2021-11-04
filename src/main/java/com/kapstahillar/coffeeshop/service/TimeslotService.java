package com.kapstahillar.coffeeshop.service;

import com.kapstahillar.coffeeshop.exception.TimeslotNotExistException;
import com.kapstahillar.coffeeshop.model.Customer;
import com.kapstahillar.coffeeshop.model.Timeslot;
import com.kapstahillar.coffeeshop.repo.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// A service for timeslots
@Service
public class TimeslotService {

    // Auto assigned from application.properties
    @Value("${slotCapacity}")
    private int maxSlotCapacity;

    @Autowired
    TimeSlotRepository timeSlotRepository;

    // Books a timeslot for customer. Validation happens first.
    // Returns timeslot reference. If passes validation, then saves data
    // to the repository.
    // if timeslot is not already present in repository, then throws TimeslotNotExistException
    public Timeslot tryToBookATimeSlot(Customer customer, Timeslot timeSlot) throws TimeslotNotExistException {
        Optional<Timeslot> optTimeSlot = timeSlotRepository.findById(timeSlot.getId());
        if (optTimeSlot.isPresent()) {
            Timeslot updatedTimeslot = optTimeSlot.get();
            if (validateBooking(customer, updatedTimeslot)) {
                updatedTimeslot.getBookedCustomers().add(customer);
                customer.getBookedTimeslots().add(updatedTimeslot);
                timeSlotRepository.save(updatedTimeslot);
            }
            return updatedTimeslot;
        }
        else {
            throw new TimeslotNotExistException("Timeslot you are trying to book, does not exist!");
        }
    }

    // Max capacity must not be reached and customer has to be unique
    private boolean validateBooking(Customer customer, Timeslot timeSlot) {
        return (maxSlotCapacity > timeSlot.getBookedCustomers().size() &&
                !timeSlot.getBookedCustomers().contains(customer));
    }

    // Returns all timeslots with customer data.
    public List<Timeslot> getAllTimeSlots() {
        return new ArrayList<Timeslot>(timeSlotRepository.findAll());
    }
}
