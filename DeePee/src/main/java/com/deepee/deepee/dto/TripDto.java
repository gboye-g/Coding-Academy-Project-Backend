package com.deepee.deepee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TripDto {

    private Long id;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;

    private String sourceLocations;

    private String destinationLocations;

    private String noOfSeats;

    public TripDto(LocalDateTime startTime, String sourceLocations, String destinationLocations, String noOfSeats) {
        this.startTime = startTime;
        this.sourceLocations = sourceLocations;
        this.destinationLocations = destinationLocations;
        this.noOfSeats = noOfSeats;
    }
}
