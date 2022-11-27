package com.deepee.deepee.controller;

import com.deepee.deepee.dto.LoginDto;
import com.deepee.deepee.dto.TripDto;
import com.deepee.deepee.dto.UserDto;
import com.deepee.deepee.entity.Customer;
import com.deepee.deepee.entity.Host;
import com.deepee.deepee.entity.Request;
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

    @PostMapping("/register-host")
    public ResponseEntity<Host> createHost(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.createHost(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Host> loginCustomer(@RequestBody LoginDto user) {
        return ResponseEntity.ok((Host)userService.login(user));
    }

    @PostMapping("/{uid}/trips")
    public ResponseEntity<String> createTrip(@PathVariable(name = "uid")Long id, @RequestBody TripDto tripDto){
        return ResponseEntity.ok(tripService.createNewTrip(id,tripDto));
    }

    @GetMapping("/{uid}/trips")
    public ResponseEntity<List<Trip>> getAllTripsByHost(@PathVariable(name = "uid") Long id){
        return ResponseEntity.ok(tripService.getAllTripsByHostId(id));
    }


    @GetMapping("/{uid}/trips/search")
    public ResponseEntity<List<Trip>> searchForTrip(@RequestParam(name = "source")String src, @RequestParam(
            name = "destination")String dest){
        return ResponseEntity.ok(tripService.searchForTrip(Locations.valueOf(src),Locations.valueOf(dest)));
    }

    @GetMapping("/{uid}/trips/{tid}/requests")
    public ResponseEntity<List<Request>> getAllRequestsForTrip(@PathVariable(name = "tid")Long id){
        return ResponseEntity.ok(requestService.getAllRequestForTrip(id));
    }

}
