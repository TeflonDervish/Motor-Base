package com.shesterki.Motor_Base_Server.repository;

import com.shesterki.Motor_Base_Server.model.PartOfHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartOfHistoryRepository extends JpaRepository<PartOfHistory, Long> {
}
