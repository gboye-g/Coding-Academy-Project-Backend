package com.deepee.deepee.entity;

import com.deepee.deepee.entity.enums.RequestStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Request extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;

    private RequestStatus requestStatus;
}
