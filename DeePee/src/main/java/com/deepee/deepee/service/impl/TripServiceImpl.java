package com.deepee.deepee.service.impl;

import com.deepee.deepee.dto.TripDto;
import com.deepee.deepee.entity.Trip;
import com.deepee.deepee.entity.enums.Locations;
import com.deepee.deepee.exception.UserException;
import com.deepee.deepee.repository.HostRepository;
import com.deepee.deepee.repository.TripRepository;
import com.deepee.deepee.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    private final HostRepository hostRepository;

    public TripServiceImpl(TripRepository tripRepository, HostRepository hostRepository) {
        this.tripRepository = tripRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public String createNewTrip(Long id, TripDto tripDto) {
        Trip trip = tripRepository.findTripBySourceLocationsAndDestinationLocationsAndHost_Id(Locations.valueOf(tripDto.getSourceLocations()),Locations.valueOf(tripDto.getDestinationLocations()),id).get();
        if(trip == null){
            createTrip(id,tripDto);
        }else{
            int startHour = trip.getStartTime().compareTo(LocalDateTime.now().plusHours(1));
            if(startHour > 0 || startHour == 0){
                throw new UserException(HttpStatus.BAD_REQUEST,"cannot upload a trip at the moment");
            }else{
                createTrip(id,tripDto);
            }
        }
        return "created";
    }

    private void createTrip(Long id,TripDto tripDto){
        Trip newTrip = new Trip();
        newTrip.setHost(hostRepository.getReferenceById(id));
        newTrip.setStartTime(tripDto.getStartTime());
        newTrip.setDestinationLocations(Locations.valueOf(tripDto.getDestinationLocations()));
        newTrip.setNoOfSeats(tripDto.getNoOfSeats());
        tripRepository.save(newTrip);
    }

    @Override
    public List<Trip> searchForTrip(Locations s, Locations d) {
        return tripRepository.findTripsBySourceLocationsAndDestinationLocations(s,d);
    }

    @Override
    public Trip getTripById(Long id) {
        return tripRepository.getReferenceById(id);
    }


    @Override
    public List<Trip> getAllTripsByHostId(Long id) {
        return tripRepository.findTripsByHostId(id);
    }
}
