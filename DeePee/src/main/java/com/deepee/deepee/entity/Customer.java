package com.deepee.deepee.entity;

import com.deepee.deepee.model.UserForm;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "id_customer")
public class Customer extends User {

    @OneToMany(mappedBy = "customer")
    private List<Trip> trips;

    @OneToMany(mappedBy = "customer")
    private List<Request> requests;

    public Customer() {
    }

    public Customer(UserForm userFormDTO, String encryptedPassword, Collection<Role> roles) {
        super(userFormDTO, encryptedPassword, roles);
    }

}
