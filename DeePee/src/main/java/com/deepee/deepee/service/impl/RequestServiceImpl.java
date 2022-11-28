package com.deepee.deepee.service.impl;

import com.deepee.deepee.entity.Customer;
import com.deepee.deepee.entity.Request;
import com.deepee.deepee.exception.UserException;
import com.deepee.deepee.repository.RequestRepository;
import com.deepee.deepee.repository.TripRepository;
import com.deepee.deepee.repository.UserRepository;
import com.deepee.deepee.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    public RequestServiceImpl(RequestRepository requestRepository, TripRepository tripRepository, UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }


    @Override
    public String sendRequestForTrip(Long tripId,Long customerId) {
        boolean requestExist = requestRepository.existsRequestByTrip_IdAndCustomer_Id(tripId,customerId);
        if(requestExist){
            throw new UserException(HttpStatus.BAD_REQUEST,"request exist");
        } else{
            Request request = new Request();
            request.setTrip(tripRepository.getReferenceById(tripId));
            request.setCustomer((Customer) userRepository.getReferenceById(customerId));
            requestRepository.save(request);
        }
        return "request created";
    }

    @Override
    public List<Request> getAllRequestForTrip(Long tid) {
        return requestRepository.findRequestsByTrip_Id(tid);
    }


}
