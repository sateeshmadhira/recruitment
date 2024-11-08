package com.ess.recruitment.core.dto;

import com.ess.recruitment.core.utils.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourcePoolDto {
    private Long resourcePoolId;
    private Long poolId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Long mobile;
    private String dateOfBirth;
    private Source source;
    private int yearsOfExperience;
    private Long panCardNumber;
    private Long aadharCardNumber;
    private Long passportNumber;
    private String city;
    private Country country;
    private State state;
    private Address address;
    private Long pinCode;
    private String skills;
    private String linkedInUrl;
    private String twitterUrl;
    private String facebookUrl;
    private String videoResume;
    private String willingToRelocate;
    private Gender gender;
    private String languagesKnown;
    private String gitHubUrl;
    private String alternateEmail;
    private MaritalStatus maritalStatus;
    private Priority priority;
    private String educationDtos;
    private String workExperienceDtos;
    private String referenceDtos;
    private String certificationDtos;
    private String documents;
}
