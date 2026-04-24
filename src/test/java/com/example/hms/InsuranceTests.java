package com.example.hms;

import com.example.hms.entity.Appointment;
import com.example.hms.entity.Insurance;
import com.example.hms.entity.Patient;
import com.example.hms.service.AppointmentService;
import com.example.hms.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;


    @Test
    public void test(){
        Insurance insurance = Insurance.builder()
                .policyNumber("SBI_123")
                .provider("SBI")
                .validDate(LocalDate.of(2028, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsurancetopatient(insurance, 1L);
        System.out.println(patient);

        var newPatient = insuranceService.disaccociatepatient(1L);
        System.out.println(newPatient);

    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 05, 01, 14, 04))
                .reason("Body checkup")
                .build();

        var newAppointment = appointmentService.createAppointment(appointment, 1L, 1L);
        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);
        System.out.println(updatedAppointment);
    }
}


