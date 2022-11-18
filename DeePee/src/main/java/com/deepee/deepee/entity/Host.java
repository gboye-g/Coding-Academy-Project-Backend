package com.deepee.deepee.entity;

import com.deepee.deepee.model.UserForm;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Hosts")
@PrimaryKeyJoinColumn(name = "id_host")
public class Host extends User {

    @OneToMany(mappedBy = "host")
    private List<Trip> trips;

    public Host() {
    }

    public Host(UserForm userFormDTO, String encryptedPassword, Collection<Role> roles) {
        super(userFormDTO, encryptedPassword, roles);
    }
    @Override
    public void update(UserForm updateData) {
        super.update(updateData);
    }


}
