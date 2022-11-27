package com.deepee.deepee.repository;

import com.deepee.deepee.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request,Long> {

    boolean existsRequestByTrip_IdAndCustomer_Id(Long trip_id, Long customer_id);

    List<Request> findRequestsByTrip_Id(Long trip_id);
}
