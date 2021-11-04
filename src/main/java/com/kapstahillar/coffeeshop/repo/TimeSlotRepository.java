package com.kapstahillar.coffeeshop.repo;

import com.kapstahillar.coffeeshop.model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<Timeslot, Long> {
}
