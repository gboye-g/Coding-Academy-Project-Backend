package com.deepee.deepee.service.impl;

import com.deepee.deepee.dto.TripDto;
import com.deepee.deepee.dto.TripResponse;
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
        Trip trip = null;
        try{
            trip = tripRepository.findTripBySourceLocationsAndDestinationLocations(Locations.valueOf(tripDto.getSourceLocations()),Locations.valueOf(tripDto.getDestinationLocations())).orElse(null);
        }catch (Exception e){
            e.printStackTrace();

        }
//        Trip trip = tripRepository.findTripBySourceLocationsAndDestinationLocations(Locations.valueOf(tripDto.getSourceLocations()),Locations.valueOf(tripDto.getDestinationLocations())).orElse(null);
        if(trip == null){
            System.out.println("its up to here");
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
        newTrip.setHost(hostRepository.findById(id).get());
        newTrip.setStartTime(tripDto.getStartTime());
        newTrip.setSourceLocations(Locations.valueOf(tripDto.getSourceLocations()));
        newTrip.setDestinationLocations(Locations.valueOf(tripDto.getDestinationLocations()));
        newTrip.setNoOfSeats(tripDto.getNoOfSeats());
        tripRepository.save(newTrip);
    }

    @Override
    public List<TripResponse> searchForTrip(Locations s, Locations d) {
        return allTrips(s,d);
    }

    @Override
    public Trip getTripById(Long id) {
        return tripRepository.getReferenceById(id);
    }


    @Override
    public List<TripDto> getAllTripsByHostId(Long id) {
        return tripRepository.findTripsByHostId(id).stream().map(trip ->mapToDto(trip)).toList();
    }


    private List<TripResponse> allTrips(Locations s, Locations d){
       return tripRepository.findAll().stream().filter(trip -> trip.getSourceLocations().toString().equals(s.toString()) && trip.getDestinationLocations().toString().equals(d.toString())).map(trip -> new TripResponse(trip.getHost().getFirstName(),
               trip.getHost().getLastName(),
               trip.getHost().getMobile(),
               trip.getHost().getPlateNumber(),
               trip.getStartTime().toString())).toList();
    }

    private TripDto mapToDto(Trip trip){
       return new TripDto(trip.getStartTime(),String.valueOf(trip.getSourceLocations()),String.valueOf(trip.getDestinationLocations()),trip.getNoOfSeats());
    }
}
