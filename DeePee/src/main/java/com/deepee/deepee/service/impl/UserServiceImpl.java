package com.deepee.deepee.service.impl;

import com.deepee.deepee.dto.LoginDto;
import com.deepee.deepee.dto.UserDto;
import com.deepee.deepee.entity.Customer;
import com.deepee.deepee.entity.Host;
import com.deepee.deepee.entity.User;
import com.deepee.deepee.entity.enums.RoleType;
import com.deepee.deepee.exception.UserException;
import com.deepee.deepee.repository.CustomerRepository;
import com.deepee.deepee.repository.HostRepository;
import com.deepee.deepee.repository.UserRepository;
import com.deepee.deepee.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Setter
@Getter
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final CustomerRepository customerRepository;
    private final HostRepository hostRepository;
    private final UserRepository userRepository;

    @Override
    public Customer createCustomer( UserDto userDto) {

        Customer customer1 = new Customer(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(),
                userDto.getMobile(), userDto.getDoB(), userDto.getIswId(), userDto.getPassword(),
                RoleType.CUSTOMER);
        return customerRepository.save(customer1);
    }

    @Override
    public Host createHost(UserDto userDto) {
        Host host1 = new Host( userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(),
                userDto.getMobile(), userDto.getDoB(), userDto.getIswId(), userDto.getPassword(), RoleType.HOST,
                userDto.getDriverLicense(), userDto.getPlateNumber());
        return hostRepository.save(host1);
    }

    @Override
    public User login(LoginDto loginDto) {
         User user1 = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()-> new UserException(HttpStatus.NOT_FOUND,"user does not exist"));
        if(!user1.getPassword().equals(loginDto.getPassword())){
            throw new UserException(HttpStatus.BAD_REQUEST,"wrong password");
        }
        return user1;
    }
}
