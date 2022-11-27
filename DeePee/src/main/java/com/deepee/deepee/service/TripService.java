package com.deepee.deepee.service;

import com.deepee.deepee.dto.TripDto;
import com.deepee.deepee.entity.Trip;
import com.deepee.deepee.entity.enums.Locations;

import java.util.List;

public interface TripService {

    String createNewTrip(Long id, TripDto tripDto);

    List<Trip> searchForTrip(Locations s, Locations d);

    Trip getTripById(Long id);


    List<Trip> getAllTripsByHostId(Long id);

}
