package com.shesterki.Motor_Base_Server.repository;

import com.shesterki.Motor_Base_Server.model.UserInofrmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInofrmation, Long> {
}
