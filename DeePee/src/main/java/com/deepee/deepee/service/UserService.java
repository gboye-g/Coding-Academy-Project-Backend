package com.deepee.deepee.service;

import com.deepee.deepee.dto.LoginDto;
import com.deepee.deepee.dto.UserDto;
import com.deepee.deepee.entity.Customer;
import com.deepee.deepee.entity.Host;
import com.deepee.deepee.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Customer createCustomer (UserDto userDto);

    Host createHost (UserDto userDto);

    User login(LoginDto user);

}
