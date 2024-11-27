package com.shesterki.Motor_Base_Server.repository;

import com.shesterki.Motor_Base_Server.model.UserFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFeedbackRepository extends JpaRepository<UserFeedback, Long> {

    List<UserFeedback> findByUserToId(Long userToId);
}
