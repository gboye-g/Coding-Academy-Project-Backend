package com.deepee.deepee.model;

import com.deepee.deepee.entity.Customer;
import com.deepee.deepee.entity.Host;
import com.deepee.deepee.entity.User;

import lombok.Data;

@Data
public class UserForm {


    private Long id;

    private String userName;

    private String password;

    private String matchingPassword;

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;



    public UserForm() {
    }

    public UserForm(User user) {
        this.setId(user.getId());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setMobile(user.getMobile());
    }

    public UserForm(Host host) {
        this((User) host);
    }

    public UserForm(Customer customer) {
        this((User) customer);
    }



}