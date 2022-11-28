package com.deepee.deepee.repository;


import com.deepee.deepee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);
}

