package com.revature.profile.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Privacy")
public class Privacy {
    @Id
    @SequenceGenerator(
            name = "privacy_sequence",
            sequenceName = "privacy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "privacy_sequence"
    )



    private Long privacyid;
    @Column(name = "email")
    private Boolean email;
    @Column(name = "dob")
    private Boolean dob;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "name")
    private Boolean name;
    @Column(name = "bio")
    private Boolean bio;



}
