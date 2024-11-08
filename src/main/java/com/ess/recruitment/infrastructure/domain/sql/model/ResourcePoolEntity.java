package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourcePoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long poolId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MOBILE")
    private Long mobile;
    @Column(name ="DATE_OF_BIRTH")
    private String dateOfBirth;
    @Column(name = "SOURCE")
    private Source source;
    @Column(name = "YEARS_OF_EXPERIENCE")
    private int yearsOfExperience;
    @Column(name = "PAN_CARD_NUMBER")
    private Long panCardNumber;
    @Column(name = "AADHAR_CARD_NUMBER")
    private Long aadharCardNumber;
    @Column(name = "PASSPORT_NUMBER")
    private Long passportNumber;
    @Column(name = "CITY")
    private String city;
  //@Enumerated(EnumType.STRING)
   @Column(name = "COUNTRY")
    private Country country;
  //@Enumerated(EnumType.STRING)
    @Column(name = "STATE")
    private State state;
    @Enumerated(EnumType.STRING)
    private Address address;
    @Column(name = "PINCODE")
    private Long pinCode;
    @Column(name = "SKILLS")
    private String skills;
    @Column(name = "LINKEDINURL")
    private String linkedInUrl;
    @Column(name = "TWITTERURL")
    private String twitterUrl;
    @Column(name = "FACEBOOKURL")
    private String facebookUrl;
    @Column(name = "VIDEORESUME")
    private String videoResume;
    @Column(name = "WILLINGTORELOCATE")
    private String willingToRelocate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "LANGUAGESKNOWN")
    private String languagesKnown;
    @Column(name = "GITHUBURL")
    private String gitHubUrl;
    @Column(name = "ALTERNATEEMAIL")
    private String alternateEmail;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Column(name = "EDUCATIONDTOS")
    private String educationDtos;
    @Column(name = "WORKEXPERIENCEDTOS")
    private String workExperienceDtos;
    @Column(name = "REFEREENCEDTOS")
    private String referenceDtos;
    @Column(name = "CERTIFICATIONDTOS")
    private String certificationDtos;
    @Column(name = "DOCUMENTS")
    private String documents;

}
