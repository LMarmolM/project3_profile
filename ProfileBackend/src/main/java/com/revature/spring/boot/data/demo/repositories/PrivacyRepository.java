package com.revature.spring.boot.data.demo.repositories;

import com.revature.spring.boot.data.demo.entities.Privacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivacyRepository extends JpaRepository<Privacy, Long> {
    Privacy findByprivacyid(Long id);
}
