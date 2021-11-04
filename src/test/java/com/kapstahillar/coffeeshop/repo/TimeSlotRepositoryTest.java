package com.kapstahillar.coffeeshop.repo;

import com.kapstahillar.coffeeshop.model.Timeslot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TimeSlotRepositoryTest {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void retrieveTwelveTimeslotsFromDatabase() {
        Collection<Timeslot> timeslots = timeSlotRepository.findAll();
        assertEquals(12, timeslots.size());
    }

}