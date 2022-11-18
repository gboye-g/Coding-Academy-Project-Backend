package com.deepee.deepee.service;

import com.deepee.deepee.entity.Trip;

import java.util.List;

public interface TripService {

    void createNewTrip();

    void updateTrip();

    void updateTripStatus();

    void deleteTripById();

    Trip getTripById();

    List<Trip> getAllTrips();

    List<Trip> getAllTripsByHostId();

    List<Trip> getAllTripsByStatus();

}
