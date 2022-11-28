package com.deepee.deepee.service;

import com.deepee.deepee.entity.Request;

import java.util.List;

public interface RequestService {

    String sendRequestForTrip(Long tripId,Long customerId);

    List<Request> getAllRequestForTrip(Long tid);
}
