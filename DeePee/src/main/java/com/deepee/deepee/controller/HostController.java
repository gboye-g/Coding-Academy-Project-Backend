package com.deepee.deepee.controller;


import com.deepee.deepee.dto.LoginDto;
import com.deepee.deepee.dto.TripDto;
import com.deepee.deepee.dto.UserDto;
import com.deepee.deepee.entity.Host;
import com.deepee.deepee.entity.Request;
import com.deepee.deepee.entity.Trip;
import com.deepee.deepee.service.RequestService;
import com.deepee.deepee.service.TripService;
import com.deepee.deepee.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/hosts")
public class HostController {

    private final UserService userService;

    private final RequestService requestService;

    private final TripService tripService;

    public HostController(UserService userService, RequestService requestService, TripService tripService) {
        this.userService = userService;
        this.requestService = requestService;
        this.tripService = tripService;
    }

    @PostMapping("/register-host")
    public ResponseEntity<Host> createHost(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.createHost(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Host> loginHost(@RequestBody LoginDto user) {
        return ResponseEntity.ok(userService.hostLogin(user));
    }


    @PostMapping("/{uid}/trips")
    public ResponseEntity<String> createTrip(@PathVariable(name = "uid")Long id, @RequestBody TripDto tripDto){
        return ResponseEntity.ok(tripService.createNewTrip(id,tripDto));
    }

    @GetMapping("/{uid}/trips")
    public ResponseEntity<List<TripDto>> getAllTripsByHost(@PathVariable(name = "uid") Long id){
        return ResponseEntity.ok(tripService.getAllTripsByHostId(id));
    }

    @GetMapping("/{uid}/trips/{tid}/requests")
    public ResponseEntity<List<Request>> getAllRequestsForTrip(@PathVariable(name = "tid")Long id){
        return ResponseEntity.ok(requestService.getAllRequestForTrip(id));
    }

}
