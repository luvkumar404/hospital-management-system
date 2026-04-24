package com.example.hms.service;

import com.example.hms.entity.Insurance;
import com.example.hms.entity.Patient;
import com.example.hms.repository.InsuranceRepository;
import com.example.hms.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository  insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsurancetopatient(Insurance insurance, Long patientId){
         Patient patient = patientRepository.findById(patientId).orElse(null);

         patient.setInsurance(insurance);
         insurance.setPatient(patient); //Bidirectional consistency maintain rahe


        return patient;
    }

    @Transactional
    public Patient disaccociatepatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElse(null);

        patient.setInsurance(null);
        return patient;
    }
}
