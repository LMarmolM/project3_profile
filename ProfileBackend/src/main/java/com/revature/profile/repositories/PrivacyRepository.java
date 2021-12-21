package com.revature.profile.repositories;

import com.revature.profile.entities.Privacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivacyRepository extends JpaRepository<Privacy, Long> {
    Privacy findByprivacyid(Long id);
}
