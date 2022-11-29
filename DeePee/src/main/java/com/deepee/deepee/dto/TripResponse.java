package com.deepee.deepee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TripResponse {
    private String fHostName;
    private String lHostName;
    private String phoneNumber;
    private String vehicleNo;
    private String startTime;
}
