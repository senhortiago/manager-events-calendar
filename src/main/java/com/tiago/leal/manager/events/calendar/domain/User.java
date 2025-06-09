package com.tiago.leal.manager.events.calendar.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private String id;

    private String name;

    private String password;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Ministry ministry;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
