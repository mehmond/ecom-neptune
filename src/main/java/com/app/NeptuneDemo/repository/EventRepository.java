package com.app.NeptuneDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.NeptuneDemo.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
}
