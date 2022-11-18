package com.deepee.deepee.entity;

import com.deepee.deepee.entity.enums.TripStatus;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "Trips")
public class Trip extends BaseEntity implements Comparable<Trip> {

    @Column(name = "start")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime start;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "end")
    private LocalDateTime end;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "canceled_at")
    private LocalDateTime canceledAt;

    @OneToOne
    @JoinColumn(name = "id_canceler")
    private User canceler;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TripStatus status;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "requestId")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "id_host")
    private Host host;


    public Trip() {
    }

    public Trip(LocalDateTime start, LocalDateTime end, Customer customer, Host host) {
        this.start = start;
        this.end = end;
        this.customer = customer;
        this.host = host;
    }

    @Override
    public int compareTo(Trip o) {
        return this.getStart().compareTo(o.getStart());
    }


}
