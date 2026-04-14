package com.example.hms.service;

import com.example.hms.entity.Paitent;
import com.example.hms.repository.PaitentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaitentService {

    private final PaitentRepository paitentRepository;

    @Transactional
    public Paitent getPaitentById(Long id){

        Paitent p1 = paitentRepository.findById(id).orElseThrow();

        Paitent p2 = paitentRepository.findById(id).orElseThrow();
        p1.setName("Raja");
        return p1;

    }
}
