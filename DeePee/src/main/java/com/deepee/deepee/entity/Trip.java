package com.deepee.deepee.entity;

import com.deepee.deepee.entity.enums.Locations;
import com.deepee.deepee.entity.enums.NoOfSeats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Trips")
public class Trip extends BaseEntity {

    @OneToMany
    @JoinColumn(name = "requestId")
    private List<Request> request;

    @ManyToOne
    @JoinColumn(name = "id_host")
    private Host host;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;

    @Enumerated(EnumType.STRING)
    private Locations sourceLocations;

    @Enumerated(EnumType.STRING)
    private Locations destinationLocations;

    private String noOfSeats;

    public Trip(Host host, LocalDateTime startTime, Locations sourceLocations, Locations destinationLocations, String noOfSeats) {
        this.host = host;
        this.startTime = startTime;
        this.sourceLocations = sourceLocations;
        this.destinationLocations = destinationLocations;
        this.noOfSeats = noOfSeats;
    }
}
