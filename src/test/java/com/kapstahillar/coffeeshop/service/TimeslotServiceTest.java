package com.kapstahillar.coffeeshop.service;

import com.kapstahillar.coffeeshop.model.Customer;
import com.kapstahillar.coffeeshop.model.Timeslot;
import com.kapstahillar.coffeeshop.repo.TimeSlotRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TimeslotServiceTest {

    @Mock
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    @InjectMocks
    private TimeslotService timeslotService;
    private Customer customer;
    private Timeslot timeSlot1;
    private Timeslot timeSlot2;
    private List<Timeslot> timeSlots;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        timeSlot1 = new Timeslot("10.00 - 10.30");
        timeSlot2 = new Timeslot("10.30 - 11.00");
        timeSlots = new ArrayList<Timeslot>();
        timeSlots.add(timeSlot1);
        timeSlots.add(timeSlot2);
    }

    @AfterEach
    void tearDown() {
        customer = null;
        timeSlot1 = null;
        timeSlot2 = null;
        timeSlots = null;
        timeSlotRepository.deleteAll();
    }

    @Test
    void getAllTimeSlots() {
        when(timeSlotRepository.findAll()).thenReturn(timeSlots);
        List<Timeslot> timeslots = timeslotService.getAllTimeSlots();
        assertEquals(2, timeslots.size());
        verify(timeSlotRepository,times(1)).findAll();
    }
}