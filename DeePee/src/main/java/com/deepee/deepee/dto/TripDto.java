package com.deepee.deepee.dto;

import com.deepee.deepee.entity.enums.Locations;
import com.deepee.deepee.entity.enums.NoOfSeats;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
public class TripDto {
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;

    @Enumerated(EnumType.STRING)
    private Locations sourceLocations;

    @Enumerated(EnumType.STRING)
    private Locations destinationLocations;

    @Enumerated(EnumType.STRING)
    private NoOfSeats noOfSeats;

    public TripDto(LocalDateTime startTime, Locations sourceLocations, Locations destinationLocations, NoOfSeats noOfSeats) {
        this.startTime = startTime;
        this.sourceLocations = sourceLocations;
        this.destinationLocations = destinationLocations;
        this.noOfSeats = noOfSeats;
    }
}
