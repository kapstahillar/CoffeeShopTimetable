package com.kapstahillar.coffeeshop.view;

import com.kapstahillar.coffeeshop.component.TimeSlotButton;
import com.kapstahillar.coffeeshop.exception.TimeslotNotExistException;
import com.kapstahillar.coffeeshop.model.Customer;
import com.kapstahillar.coffeeshop.model.Timeslot;
import com.kapstahillar.coffeeshop.service.CustomerService;
import com.kapstahillar.coffeeshop.service.TimeslotService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    @Autowired
    private TimeslotService timeSlotService;

    @Autowired
    private CustomerService customerService;

    // Auto assigned from application.properties
    @Value("${slotCapacity}")
    private int maxSlotCapacity;

    // List of timeslots
    private List<Timeslot> timeslots;

    // Main user for this view.
    // On page reload, user cannot be used again and client
    // gets new user. Old user's data won't disappear before
    // server reload.
    private Customer customer;

    // Called after setting up app. It's called after the autowiring,
    // so it's safe to use the services here.
    // Creates new customer for app to use and gets timeslots
    @PostConstruct
    private void init() {
        customer = new Customer();
        customerService.registerCustomer(customer);
        initView();
    }

    // Initialises view components
    private void initView() {
        addTimeSlots();
    }

    // Generates the timeslots based on the slotsNames string array
    // Capacity can be modified in the .properties file
    // Also registers click event callback OnmTimeSlotClicked
    private void addTimeSlots() {
        timeslots = timeSlotService.getAllTimeSlots();
        for (Timeslot timeSlot : timeslots) {
            int slotRemainingCapacity = maxSlotCapacity - timeSlot.getBookedCustomers().size();
            TimeSlotButton button = new TimeSlotButton(timeSlot, slotRemainingCapacity, maxSlotCapacity);
            MainView _this = this;
            button.addClickListener(event -> {
                _this.OnTimeSlotClicked(button);
            });
            add(button);
        }
    }

    // Callback event when TimeSlotButton is clicked
    // Tries to book customer to a clicked timeslot
    // If fails to book, then logic throws TimeslotNotExistException which
    // needs to be handled
    private void OnTimeSlotClicked(TimeSlotButton button) {
        if (!button.getTimeSlot().getBookedCustomers().contains(customer) &&
                button.getTimeSlot().getBookedCustomers().size() < maxSlotCapacity) {
            try {
                Timeslot updatedTimeslot = timeSlotService.tryToBookATimeSlot(customer, button.getTimeSlot());
                boolean success = updatedTimeslot.getBookedCustomers().contains(customer);
                button.updateTimeSlot(updatedTimeslot, success);
            } catch (TimeslotNotExistException ex) {
                // Some complex error handling logic
                System.out.println(ex.getMessage());
            }
        }
    }
}
