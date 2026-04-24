package com.example.hms;

import com.example.hms.entity.Patient;
import com.example.hms.repository.PatientRepository;
import com.example.hms.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> paitentList = patientRepository.findAll();
        System.out.println(paitentList);
    }

    @Test
    public void testTransactionMethod(){
//        Paitent paitent = paitentService. getPaitentById(123L);
//        System.out.println(paitent);


//        List<Paitent> paitentList = paitentRepository.findByBloodGroup(BloodGroup.A_POSITIVE);



          Page<Patient> paitentList = patientRepository.findAllPatient(PageRequest.of(0,1));

        for(Patient paitent : paitentList){
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
