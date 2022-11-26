package com.deepee.deepee.service.impl;

import com.deepee.deepee.dto.UserDto;
import com.deepee.deepee.entity.Customer;
import com.deepee.deepee.entity.Host;
import com.deepee.deepee.entity.enums.RoleType;
import com.deepee.deepee.repository.CustomerRepository;
import com.deepee.deepee.repository.HostRepository;
import com.deepee.deepee.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final CustomerRepository customerRepository;
    private final HostRepository hostRepository;

    @Override
    public Customer createCustomer( UserDto userDto) {
//        User user = userRepository.findUserByEmail(userDto.getEmail());
//        if (user != null){
//            throw new Exception("User with email already exist");
//        }

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

//    @Override
//    public String login(LoginRequest request) {
//        User user = userRepository.findUserByEmail(request.getEmail());
//
//    }

}
