package com.example.hms.service;

import com.example.hms.entity.Insurance;
import com.example.hms.entity.Paitent;
import com.example.hms.repository.InsuranceRepository;
import com.example.hms.repository.PaitentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository  insuranceRepository;
    private final PaitentRepository paitentRepository;

    @Transactional
    public Paitent assignInsurancetoPaitent(Insurance insurance, Long paitentId){
         Paitent paitent = paitentRepository.findById(paitentId).orElse(null);

         paitent.setInsurance(insurance);
         insurance.setPaitent(paitent); //Bidirectional consistency maintain rahe


        return paitent;
    }

    @Transactional
    public Paitent disaccociatePaitent(Long paitentId){
        Paitent paitent = paitentRepository.findById(paitentId).orElse(null);

        paitent.setInsurance(null);
        return paitent;
    }
}
