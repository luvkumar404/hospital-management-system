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
import java.util.ArrayList;
import java.util.List;

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

//    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createTime;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "paitent_insurance_id") //owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "paitent", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();
}
