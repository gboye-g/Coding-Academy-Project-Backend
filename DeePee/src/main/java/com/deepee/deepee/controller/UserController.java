package com.deepee.deepee.controller;

import com.deepee.deepee.dto.LoginDto;
import com.deepee.deepee.dto.UserDto;
import com.deepee.deepee.entity.Customer;
import com.deepee.deepee.entity.Trip;
import com.deepee.deepee.entity.enums.Locations;
import com.deepee.deepee.service.RequestService;
import com.deepee.deepee.service.TripService;
import com.deepee.deepee.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/users")
@CrossOrigin(origins = "*")
@RestController
public class UserController {
    private final UserService userService;
    private final TripService tripService;
    private final RequestService requestService;

    public UserController(UserService userService, TripService tripService, RequestService requestService) {
        this.userService = userService;
        this.tripService = tripService;
        this.requestService = requestService;
    }

    @PostMapping("/register-customer")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.createCustomer(user), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<Customer> loginCustomer(@RequestBody LoginDto user) {
        return ResponseEntity.ok(userService.customerLogin(user));
    }


    @GetMapping("/{uid}/trips/search")
    public ResponseEntity<List<Trip>> searchForTrip(@RequestParam(name = "source")String src, @RequestParam(
            name = "destination")String dest){
        return ResponseEntity.ok(tripService.searchForTrip(Locations.valueOf(src),Locations.valueOf(dest)));
    }


    @PostMapping("/{uid}/trips/{tid}/requests")
    public ResponseEntity<String> createRequestForTrip(@PathVariable(name = "uid")Long idu,@PathVariable(name = "tid")Long idt){
        return ResponseEntity.ok(requestService.sendRequestForTrip(idt,idu));
    }
}
