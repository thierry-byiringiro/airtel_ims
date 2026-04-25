package com.airtel_managment_system.controller;

import com.airtel_managment_system.model.Assignment;
import com.airtel_managment_system.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assignments")
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final AssetService assetService;
    private final EmployeeService employeeService;

    public AssignmentController(AssignmentService assignmentService,
                                AssetService assetService,
                                EmployeeService employeeService) {
        this.assignmentService = assignmentService;
        this.assetService = assetService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("assignments", assignmentService.getAll());
        return "assignments";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("assignment", new Assignment());
        model.addAttribute("assets", assetService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "assignment-form";
    }

    @PostMapping("/assign")
    public String assign(@RequestParam Long assetId,@RequestParam Long employeeId) {
        assignmentService.assign(assetId,employeeId);
        return "redirect:/assignments";
    }

    @GetMapping("/return/{id}")
    public String returnAsset(@PathVariable Long id) {
        assignmentService.returnAsset(id, "Good");
        return "redirect:/assignments";
    }
}