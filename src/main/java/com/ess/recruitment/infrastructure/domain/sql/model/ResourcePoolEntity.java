package com.ess.recruitment.infrastructure.domain.sql.model;

import com.ess.recruitment.core.utils.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourcePoolEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long poolId;

    private String resourceCode;

    @NotNull(message = "FIRST_NAME IS MANDATORY")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "IS_ACTIVE")
    private Integer delFlag=1;

    @NotNull(message = "MIDDLE_NAME IS MANDATORY")
    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @NotNull(message = "LAST_NAME IS MANDATORY")
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull(message = "EMAIL IS MANDATORY")
    @Column(name = "EMAIL")
    private String email;

    @NotNull(message = "MOBILE IS MANDATORY")
    @Column(name = "MOBILE")
    private Long mobile;

    @NotNull(message = "DATE_OF_BIRTH IS MANDATORY")
    @Column(name ="DATE_OF_BIRTH")
    private String dateOfBirth;

    @NotNull(message = "SOURCE IS MANDATORY")
    @Column(name = "SOURCE")
    private Source source;

    @NotNull(message = "YEARS_OF_EXPERIENCE IS MANDATORY")
    @Column(name = "YEARS_OF_EXPERIENCE")
    private int yearsOfExperience;

    @NotNull(message = "PAN_CARD_NUMBER IS MANDATORY")
    @Column(name = "PAN_CARD_NUMBER")
    private Long panCardNumber;

    @NotNull(message = "AADHAR_CARD_NUMBER IS MANDATORY")
    @Column(name = "AADHAR_CARD_NUMBER")
    private Long aadharCardNumber;

    @NotNull(message = "PASSPORT_NUMBER IS MANDATORY")
    @Column(name = "PASSPORT_NUMBER")
    private Long passportNumber;

    @NotNull(message = "CITY IS MANDATORY")
    @Column(name = "CITY")
    private String city;
  //@Enumerated(EnumType.STRING)
  @NotNull(message = "COUNTRY IS MANDATORY")
   @Column(name = "COUNTRY")
    private Country country;
  //@Enumerated(EnumType.STRING)

    @NotNull(message = "STATE IS MANDATORY")
    @Column(name = "STATE")
    private State state;

    @NotNull(message = "ADDRESS IS MANDATORY")
    @Enumerated(EnumType.STRING)
    private Address address;

    @NotNull(message = "PINCODE IS MANDATORY")
    @Column(name = "PINCODE")
    private Long pinCode;

    @NotNull(message = "SKILLS IS MANDATORY")
    @Column(name = "SKILLS")
    private String skills;

    @NotNull(message = "STATUS IS MANDATORY")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull(message = "LINKED_IN_URL IS MANDATORY")
    @Column(name = "LINKEDINURL")
    private String linkedInUrl;

    @NotNull(message = "TWITTER_URL IS MANDATORY")
    @Column(name = "TWITTERURL")
    private String twitterUrl;

    @NotNull(message = "FACEBOOK_URL IS MANDATORY")
    @Column(name = "FACEBOOKURL")
    private String facebookUrl;

    @NotNull(message = "VIDEO_RESUME IS MANDATORY")
    @Column(name = "VIDEORESUME")
    private String videoResume;

    @NotNull(message = "WILLING_TO_RELOCATE IS MANDATORY")
    @Column(name = "WILLINGTORELOCATE")
    private String willingToRelocate;

    @NotNull(message = "GENDER IS MANDATORY")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "LANGUAGES_KNOWN IS MANDATORY")
    @Column(name = "LANGUAGESKNOWN")
    private String languagesKnown;

    @NotNull(message = "GITHUBURL IS MANDATORY")
    @Column(name = "GITHUBURL")
    private String gitHubUrl;

    @NotNull(message = "ALTERNATE_MAIL IS MANDATORY")
    @Column(name = "ALTERNATEEMAIL")
    private String alternateEmail;

    @NotNull(message = "MARITAL_STATUS IS MANDATORY")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @NotNull(message = "PRIORITY IS MANDATORY")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @NotNull(message = "EDUCATION_DTOS IS MANDATORY")
    @Column(name = "EDUCATIONDTOS")
    private String educationDtos;

    @NotNull(message = "WORK_EXPERIENCE_DTOS IS MANDATORY")
    @Column(name = "WORKEXPERIENCEDTOS")
    private String workExperienceDtos;

    @NotNull(message = "REFERENCE_DTOS IS MANDATORY")
    @Column(name = "REFEREENCEDTOS")
    private String referenceDtos;

    @NotNull(message = "CERTIFICATION_DTOS IS MANDATORY")
    @Column(name = "CERTIFICATIONDTOS")
    private String certificationDtos;

    @NotNull(message = "DOCUMENTS IS MANDATORY")
    @Column(name = "DOCUMENTS")
    private String documents;

}
