package com.deepee.deepee.entity;

import com.deepee.deepee.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String mobile;

    private String DoB;

    @Column(name = "ISW_id")
    private String ISWid;

    private String password;

    private String passwordh;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

}
