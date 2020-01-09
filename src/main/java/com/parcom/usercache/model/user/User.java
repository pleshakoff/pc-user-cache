package com.parcom.usercache.model.user;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
@RedisHash(value = "User",timeToLive = 300L)

public class User {
    @Id
    private final Long id;
    private final String firstName;
    private final String middleName;
    private final String familyName;
    private final String email;
    private final String phone;

}