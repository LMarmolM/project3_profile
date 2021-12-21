package com.revature.profile.repositories;

import com.revature.profile.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    List<Profile> findByusername(String username);
    Profile findByusernameAndPassword(String username, String password);


}
