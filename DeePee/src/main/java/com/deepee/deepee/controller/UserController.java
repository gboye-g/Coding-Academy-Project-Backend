package com.deepee.deepee.controller;

import com.deepee.deepee.dto.UserDto;
import com.deepee.deepee.entity.Customer;
import com.deepee.deepee.entity.Host;
import com.deepee.deepee.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/user")
@AllArgsConstructor
@RestController
public class UserController {
    private UserService userService;

    @PostMapping("/register-customer")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.createCustomer(user), HttpStatus.CREATED);
    }

    @PostMapping("/register-host")
    public ResponseEntity<Host> createHost(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.createHost(user), HttpStatus.CREATED);
    }
}
