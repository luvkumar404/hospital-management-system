package com.example.hms;

import com.example.hms.dto.BloodGroupCountResponseEntity;
import com.example.hms.entity.Paitent;
import com.example.hms.entity.type.BloodGroup;
import com.example.hms.repository.PaitentRepository;
import com.example.hms.service.PaitentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
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
//        Paitent paitent = paitentService. getPaitentById(123L);
//        System.out.println(paitent);


//        List<Paitent> paitentList = paitentRepository.findByBloodGroup(BloodGroup.A_POSITIVE);



          Page<Paitent> paitentList = paitentRepository.findAllPaitent(PageRequest.of(0,1));

        for(Paitent paitent : paitentList){
            System.out.println(paitent);
        }
//
//        List<Object[]> bloodGroupList = paitentRepository.countEachBloodGroupType();
//        for(Object[] bloodGroup : bloodGroupList){
//            System.out.println(bloodGroup[0]+" "+bloodGroup[1]);
//        }

//        int rowsUpdated = paitentRepository.updateNamewithId("Raja", 1L);
//        System.out.println(rowsUpdated);

//        List<BloodGroupCountResponseEntity> bloodGroupList = paitentRepository.countEachBloodGroup();
//        for(BloodGroupCountResponseEntity bloodGroup : bloodGroupList){
//            System.out.println(bloodGroup);
//        }
    }
}
