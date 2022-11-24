package com.deepee.deepee.entity;

import com.deepee.deepee.entity.enums.RoleType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer extends User {

    @OneToMany(mappedBy = "customer")
    private List<Request> requests;

    public Customer(String firstName, String lastName, String email, String mobile, String DoB, String ISWid, String password, RoleType roleType) {
        super(firstName, lastName, email, mobile, DoB, ISWid, password, roleType);
    }
}
