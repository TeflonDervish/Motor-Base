package com.shesterki.Motor_Base_Server.repository;

import com.shesterki.Motor_Base_Server.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
}
