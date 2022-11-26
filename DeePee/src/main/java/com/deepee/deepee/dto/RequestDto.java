package com.deepee.deepee.dto;

import com.deepee.deepee.entity.enums.Locations;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class RequestDto {
    private Long id;

    @Enumerated(EnumType.STRING)
    private Locations sourceLocations;

    @Enumerated(EnumType.STRING)
    private Locations destinationLocations;

    public RequestDto(Locations sourceLocations, Locations destinationLocations) {
        this.sourceLocations = sourceLocations;
        this.destinationLocations = destinationLocations;
    }
}
