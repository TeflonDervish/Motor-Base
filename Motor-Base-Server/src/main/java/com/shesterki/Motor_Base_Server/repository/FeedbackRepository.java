package com.shesterki.Motor_Base_Server.repository;

import com.shesterki.Motor_Base_Server.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
