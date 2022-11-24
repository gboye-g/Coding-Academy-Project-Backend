package com.deepee.deepee.entity;

import com.deepee.deepee.entity.enums.Locations;
import com.deepee.deepee.entity.enums.NoOfSeats;
import com.deepee.deepee.entity.enums.TripStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Trips")
public class Trip extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "id_canceler")
    private User canceler;

    @OneToMany
    @JoinColumn(name = "requestId")
    private List<Request> request;

    @ManyToOne
    @JoinColumn(name = "id_host")
    private Host host;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private Locations sourceLocations;

    @Enumerated(EnumType.STRING)
    private Locations destinationLocations;

    @Enumerated(EnumType.STRING)
    private NoOfSeats noOfSeats;

    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;

    public Trip(User canceler, Host host, LocalDateTime startTime, LocalDateTime endTime, Locations sourceLocations, Locations destinationLocations, NoOfSeats noOfSeats, TripStatus tripStatus) {
        this.canceler = canceler;
        this.host = host;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sourceLocations = sourceLocations;
        this.destinationLocations = destinationLocations;
        this.noOfSeats = noOfSeats;
        this.tripStatus = tripStatus;
    }
}
