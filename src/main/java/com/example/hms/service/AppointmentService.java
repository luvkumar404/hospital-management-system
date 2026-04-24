package com.example.hms.service;

import com.example.hms.entity.Appointment;
import com.example.hms.entity.Doctor;
import com.example.hms.entity.Paitent;
import com.example.hms.repository.AppointmentRepository;
import com.example.hms.repository.DoctorRepository;
import com.example.hms.repository.PaitentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PaitentRepository paitentRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long paitentId ){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Paitent paitent = paitentRepository.findById(paitentId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have an id");

        appointment.setPaitent(paitent);
        appointment.setDoctor(doctor);

        paitent.getAppointments().add(appointment); // maintain karega bidirectional consistency

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
         Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
         Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

         appointment.setDoctor(doctor); // automatically update because dirty now

        doctor.getAppointments().add(appointment); // bidirectional
        return appointment;
    }
}
