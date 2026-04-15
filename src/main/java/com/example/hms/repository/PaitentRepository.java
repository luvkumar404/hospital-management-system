package com.example.hms.repository;

import com.example.hms.dto.BloodGroupCountResponseEntity;
import com.example.hms.entity.Paitent;
import com.example.hms.entity.type.BloodGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaitentRepository extends JpaRepository<Paitent,Long> {


    Paitent findByName(String name);
    List<Paitent> findByBirthDateOrEmail(LocalDate birthDate, String email);
    List<Paitent> findByBirthDateBetween(LocalDate birthDate1, LocalDate birthDate2);

    @Query("select p from Paitent p where p.bloodGroup = ?1")
    List<Paitent> findByBloodGroup(@Param("bloodGroup") BloodGroup bloodGroup);

    @Query("select p from Paitent p where p.birthDate > :birthDate")
    List<Paitent> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("SELECT new com.example.hms.dto.BloodGroupCountResponseEntity(p.bloodGroup, COUNT(p)) " +
            "FROM Paitent p GROUP BY p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroup();

    @Query(value = "select * from paitent", nativeQuery = true)
    Page<Paitent> findAllPaitent(Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Paitent p SET p.name = :name where p.id = :id")
    int updateNamewithId(@Param("name")  String name, @Param("id") Long id);

}
