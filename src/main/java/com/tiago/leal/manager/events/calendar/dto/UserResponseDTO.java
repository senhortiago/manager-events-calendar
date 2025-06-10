package com.tiago.leal.manager.events.calendar.dto;

import com.tiago.leal.manager.events.calendar.domain.Ministry;
import com.tiago.leal.manager.events.calendar.domain.UserType;

import java.time.LocalDateTime;

public record UserResponseDTO(String id, String name, String email, Ministry ministry, UserType userType, LocalDateTime createTime, LocalDateTime updateTime) {
}
