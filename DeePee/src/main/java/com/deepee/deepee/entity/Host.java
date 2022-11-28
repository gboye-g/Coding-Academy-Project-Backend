package com.deepee.deepee.entity;

import com.deepee.deepee.entity.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@ToString
@Entity
public class Host extends User {

    @OneToMany(mappedBy = "host")
    private List<Trip> trips;

    private String driverLicense;

    private String plateNumber;

    public Host(String firstName, String lastName, String email, String mobile, String doB, String ISWid, String password, RoleType roleType, String driverLicense, String plateNumber) {
        super(firstName, lastName, email, mobile, doB, ISWid, password, roleType);
        this.driverLicense = driverLicense;
        this.plateNumber = plateNumber;
    }

    @JsonManagedReference
    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
