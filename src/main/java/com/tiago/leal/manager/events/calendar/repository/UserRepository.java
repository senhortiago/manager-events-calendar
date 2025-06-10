package com.tiago.leal.manager.events.calendar.repository;

import com.tiago.leal.manager.events.calendar.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,String> {
    Optional<User> findByEmail(String email);
}
