package com.deepee.deepee.entity;

import com.deepee.deepee.entity.enums.RoleType;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String mobile;

    private String doB;

    @Column(name = "ISW_id")
    private String ISWid;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

}
