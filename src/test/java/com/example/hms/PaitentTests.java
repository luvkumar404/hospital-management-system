package com.example.hms;

import com.example.hms.entity.Paitent;
import com.example.hms.repository.PaitentRepository;
import com.example.hms.service.PaitentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PaitentTests {

    @Autowired
    private PaitentRepository paitentRepository;

    @Autowired
    private PaitentService paitentService;

    @Test
    public void testPaitentRepository(){
        List<Paitent> paitentList = paitentRepository.findAll();
        System.out.println(paitentList);
    }

    @Test
    public void testTransactionMethod(){
        Paitent paitent = paitentService. getPaitentById(123L);
        System.out.println(paitent);
    }
}
