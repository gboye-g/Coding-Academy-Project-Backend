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

        boolean userExist = userRepository.existsUserByEmail(userDto.getEmail());

        if(userExist){
            throw new UserException(HttpStatus.BAD_REQUEST,"user email already existed");
        }else{
            User customer1 = new Customer(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(),
                    userDto.getMobile(), userDto.getDoB(), userDto.getIswId(), userDto.getPassword(),
                    RoleType.CUSTOMER);
            return (Customer) userRepository.save(customer1);
        }

    }

    @Override
    public Host createHost(UserDto userDto) {
        User host1 = new Host( userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(),
                userDto.getMobile(), userDto.getDoB(), userDto.getIswId(), userDto.getPassword(), RoleType.HOST,
                userDto.getDriverLicense(), userDto.getPlateNumber());
        return (Host) userRepository.save(host1);
    }

    @Override
    public Host hostLogin(LoginDto loginDto) {
        Host user1 = hostRepository.findUserByEmail(loginDto.getEmail()).orElseThrow(()-> new UserException(HttpStatus.NOT_FOUND,"user does not exist"));
        if(!user1.getPassword().equals(loginDto.getPassword())){
            throw new UserException(HttpStatus.BAD_REQUEST,"wrong password");
        }
        return user1;
    }

    @Override
    public Customer customerLogin(LoginDto loginDto) {
        Customer user1 = customerRepository.findUserByEmail(loginDto.getEmail()).orElseThrow(()-> new UserException(HttpStatus.NOT_FOUND,"user does not exist"));
        if(!user1.getPassword().equals(loginDto.getPassword())){
            throw new UserException(HttpStatus.BAD_REQUEST,"wrong password");
        }
        return user1;
    }


//    @Override
//    public User login( LoginDto loginDto) {
//        Optional<User> findByEmail = userRepository.findByEmail(loginDto.getEmail());
//        System.out.println("I got here 1");
//        if (findByEmail.get() != null) {
//            System.out.println(findByEmail.get());
//            System.out.println("I got here 2");
//            return findByEmail.get();
//        }
//        System.out.println("I got here 3");
//        throw new UserException("Email or password is incorrect");
//    }

}
