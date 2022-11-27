package com.deepee.deepee.repository;

import com.deepee.deepee.entity.Trip;
import com.deepee.deepee.entity.enums.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip,Long> {

    Optional<Trip> findTripBySourceLocationsAndDestinationLocationsAndHost_Id(Locations sourceLocations, Locations destinationLocations, Long host_id);

    List<Trip> findTripsByHostId(Long host_id);

    List<Trip> findTripsBySourceLocationsAndDestinationLocations(Locations sourceLocations, Locations destinationLocations);
}
