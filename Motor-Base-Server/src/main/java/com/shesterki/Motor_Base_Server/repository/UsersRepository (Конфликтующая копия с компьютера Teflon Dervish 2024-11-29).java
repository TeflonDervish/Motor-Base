package com.shesterki.Motor_Base_Server.repository;


import com.shesterki.Motor_Base_Server.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    Set<Users> findByName(String name);
    Set<Users> findBySurname(String surname);
    Set<Users> findByPhoneNumber(String phoneNumber);
    Set<Users> findByCity(String city);
    Set<Users> findByBirthday(LocalDate birthday);
}
