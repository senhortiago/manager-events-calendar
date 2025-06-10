package com.tiago.leal.manager.events.calendar.dto;

import com.tiago.leal.manager.events.calendar.domain.Ministry;
import com.tiago.leal.manager.events.calendar.domain.UserType;

public record UserRequestDTO(String name, String password, String email,
                             Ministry ministry, UserType userType) {
}
