package com.deepee.deepee.service;

import com.deepee.deepee.dto.TripDto;
import com.deepee.deepee.entity.Request;
import com.deepee.deepee.entity.Trip;
import com.deepee.deepee.entity.enums.Locations;

import java.util.List;

public interface RequestService {

    String sendRequestForTrip(Long tid,Long rid);

    List<Request> getAllRequestForTrip(Long tid);
}
