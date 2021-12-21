package com.revature.spring.boot.data.demo.repositories;

import com.revature.spring.boot.data.demo.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    List<Profile> findByusername(String username);
    Profile findByusernameAndPassword(String username, String password);


}
