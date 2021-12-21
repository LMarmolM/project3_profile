package com.revature.profile.repositories;

import com.revature.profile.entities.Privacy;
import com.revature.profile.entities.Profile;
import com.revature.profile.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProfileRepositoryTest {

    @Autowired
    private ProfileRepository repository2;

    @Autowired
    private PrivacyRepository repository3;



    @Test
        public void savePrivacy(){
            Privacy privacy = Privacy.builder()
                    .email(false)
                    .dob(false)
                    .gender(false)
                    .name(false)
                    .bio(false)
                    .build();
            repository3.save(privacy);
    }

    @Test
    public void saveProfile() {
        Privacy privacy = new Privacy();
        privacy.setPrivacyid(1L);
        Profile profile = Profile.builder()
                .username("will3b32434333")
                .password("password")
                .email("wjbecht4334343443322lb2be@gmail.com")
                .name("will bechtle")
                .alias("wjb")
                .dob("06/17/1998")
                .gender("male")
                .bio("hello im will")
                .profilepic("/some_image")
                .privacys(privacy)
                .build();
        repository2.save(profile);
    }

}

