package com.deepee.deepee.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;

    private String doB;

    private String iswId;

    private String password;

    private String driverLicense;

    private String plateNumber;

    public UserDto(String firstName, String lastName, String email, String mobile, String doB, String iswId, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.doB = doB;
        this.iswId = iswId;
        this.password = password;
    }

    public UserDto(String firstName, String lastName, String email, String mobile, String doB, String iswId, String password, String driverLicense, String plateNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.doB = doB;
        this.iswId = iswId;
        this.password = password;
        this.driverLicense = driverLicense;
        this.plateNumber = plateNumber;
    }

}
