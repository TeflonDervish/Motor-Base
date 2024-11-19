package com.shesterki.Motor_Base_Server.repository;


import com.shesterki.Motor_Base_Server.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
