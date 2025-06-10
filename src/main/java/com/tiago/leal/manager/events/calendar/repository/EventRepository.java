package com.tiago.leal.manager.events.calendar.repository;

import com.tiago.leal.manager.events.calendar.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
}
