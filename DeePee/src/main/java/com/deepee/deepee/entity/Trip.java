package com.deepee.deepee.entity;

import com.deepee.deepee.entity.enums.Locations;
import com.deepee.deepee.entity.enums.NoOfSeats;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    @JsonManagedReference
    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }
    @JsonBackReference
    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @JsonBackReference
    public Locations getSourceLocations() {
        return sourceLocations;
    }

    public void setSourceLocations(Locations sourceLocations) {
        this.sourceLocations = sourceLocations;
    }

    @JsonBackReference
    public Locations getDestinationLocations() {
        return destinationLocations;
    }

    public void setDestinationLocations(Locations destinationLocations) {
        this.destinationLocations = destinationLocations;
    }

    public String getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(String noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
}
