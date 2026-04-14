package com.example.hms.entity;

import com.example.hms.entity.type.BloodGroup;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Table (
        name = "paitent",
        uniqueConstraints = {
//                @UniqueConstraint(name = "unique_paitent_email", columnNames =  {"email"}),
                @UniqueConstraint(name = "unique_paitent_name_birthDate", columnNames = {"name"})
        },
        indexes = {
                @Index(name = "idx_paitent_bithDate", columnList = "birthDate")
        }
)


public class Paitent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 44)
    private String name;

    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
}
