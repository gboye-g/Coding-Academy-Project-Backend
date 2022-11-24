package com.deepee.deepee.service;

import com.deepee.deepee.dto.UserDto;

public interface UserService {

    void createCustomer(UserDto userDto);

    void createHost(UserDto userDto);
}
