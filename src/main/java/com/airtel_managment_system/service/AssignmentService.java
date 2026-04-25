package com.airtel_managment_system.service;

import com.airtel_managment_system.model.*;
import com.airtel_managment_system.repository.*;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AssetRepository assetRepository;
    private final EmployeeRepository employeeRepository;

    public AssignmentService(AssignmentRepository assignmentRepository,
                             AssetRepository assetRepository,
                             EmployeeRepository employeeRepository) {
        this.assignmentRepository = assignmentRepository;
        this.assetRepository = assetRepository;
        this.employeeRepository = employeeRepository;
    }

    // ✅ FIXED ASSIGN LOGIC
    public Assignment assign(Long assetId, Long employeeId) {

        // safety check
        if (assetId == null || employeeId == null) {
            throw new RuntimeException("Asset or Employee ID cannot be null");
        }

        // fetch real entities from DB
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // create assignment
        Assignment assignment = new Assignment();
        assignment.setAsset(asset);
        assignment.setEmployee(employee);
        assignment.setIssueDate(LocalDate.now());

        // update asset status
        asset.setStatus(AssetStatus.IN_USE);

        return assignmentRepository.save(assignment);
    }

    // RETURN ASSET
    public Assignment returnAsset(Long assignmentId, String condition) {

        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        assignment.setReturnDate(LocalDate.now());
        assignment.setConditionOnReturn(condition);

        Asset asset = assignment.getAsset();
        asset.setStatus(AssetStatus.AVAILABLE);

        return assignmentRepository.save(assignment);
    }

    // LIST ALL
    public List<Assignment> getAll() {
        return assignmentRepository.findAll();
    }
}