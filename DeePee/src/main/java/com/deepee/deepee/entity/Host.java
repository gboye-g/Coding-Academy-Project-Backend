package com.deepee.deepee.entity;

import com.deepee.deepee.entity.enums.RoleType;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Hosts")
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
}
