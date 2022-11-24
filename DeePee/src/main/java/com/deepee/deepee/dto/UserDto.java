package com.deepee.deepee.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;

    private String driverLicense;

    private String plateNumber;

    public UserDto(String userName, String password, String firstName, String lastName, String email, String mobile) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
    }

    public UserDto(String userName, String password, String firstName, String lastName, String email, String mobile, String driverLicense, String plateNumber) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.driverLicense = driverLicense;
        this.plateNumber = plateNumber;
    }
}
