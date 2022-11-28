package com.deepee.deepee.repository;

import com.deepee.deepee.entity.Host;
import com.deepee.deepee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HostRepository extends JpaRepository<Host,Long> {

    Optional<Host> findUserByEmail(String email);

}
