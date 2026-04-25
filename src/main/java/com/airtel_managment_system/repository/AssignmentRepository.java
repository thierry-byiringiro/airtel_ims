package com.airtel_managment_system.repository;

import com.airtel_managment_system.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}