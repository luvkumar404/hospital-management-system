package com.example.hms.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime apppointmentTime;

    @Column(length = 100)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "paitent_id", nullable = false) //Paitent is required and not nullable
    private Paitent paitent;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;

}
