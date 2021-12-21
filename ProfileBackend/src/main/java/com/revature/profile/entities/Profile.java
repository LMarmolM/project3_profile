package com.revature.profile.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Profile")
public class Profile {
    @Id
    @SequenceGenerator(
            name = "profile_sequence",
            sequenceName = "profile_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profile_sequence"
    )
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name= "name")
    private String name;
    @Column(name = "alias", nullable = false)
    private String alias;
    @Column(name = "dob")
    private String dob;
    @Column(name = "gender")
    private String gender;
    @Column(name= "bio")
    private String bio;
    @Column(name = "profilepic")
    private String profilepic;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "privacy_id")
    private Privacy privacys;



}
