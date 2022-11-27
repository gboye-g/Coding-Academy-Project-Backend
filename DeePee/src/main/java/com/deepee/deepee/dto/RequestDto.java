package com.deepee.deepee.dto;

import com.deepee.deepee.entity.enums.Locations;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Getter
@Setter
@Data
public class RequestDto {
    private Long id;

    private Long tripId;
}
