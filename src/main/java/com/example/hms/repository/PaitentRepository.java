package com.example.hms.repository;

import com.example.hms.entity.Paitent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaitentRepository extends JpaRepository<Paitent,Long> {


}
