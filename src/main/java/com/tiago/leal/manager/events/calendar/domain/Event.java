package com.tiago.leal.manager.events.calendar.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, name = "id")
    private String id;

    private String eventName;

    private String description;

    @Enumerated(EnumType.STRING)
    private Ministry ministry;

    private BigDecimal cost;

    private  boolean transport;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private DayShift dayShift;

    @ManyToOne
    private User creator;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
