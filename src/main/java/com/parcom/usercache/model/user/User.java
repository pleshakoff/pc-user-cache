package com.parcom.usercache.model.user;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
public class User {

    private final Long id;
    private final String firstName;
    private final String middleName;
    private final String familyName;
    private final String email;
    private final String phone;

}