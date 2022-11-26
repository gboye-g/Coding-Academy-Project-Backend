package com.deepee.deepee.service;

import com.deepee.deepee.dto.UserDto;
import com.deepee.deepee.entity.Customer;
import com.deepee.deepee.entity.Host;

public interface UserService {

    Customer createCustomer (UserDto userDto);

    Host createHost (UserDto userDto);

//    String login (LoginRequest request);

//    void createHost(UserDto userDto);
}
