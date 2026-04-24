package com.example.hms.service;

import com.example.hms.entity.Appointment;
import com.example.hms.entity.Doctor;
import com.example.hms.entity.Patient;
import com.example.hms.repository.AppointmentRepository;
import com.example.hms.repository.DoctorRepository;
import com.example.hms.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId ){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have an id");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment); // maintain karega bidirectional consistency

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
