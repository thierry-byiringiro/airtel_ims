package com.airtel_managment_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.airtel_managment_system.service.AssetService;
import com.airtel_managment_system.service.EmployeeService;
import com.airtel_managment_system.model.AssetStatus;

@Controller
public class MainController {

    private final AssetService assetService;
    private final EmployeeService employeeService;

    public MainController(AssetService assetService, EmployeeService employeeService) {
        this.assetService = assetService;
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("totalAssets", assetService.getAll().size());
        model.addAttribute("inUseAssets", assetService.getByStatus(AssetStatus.IN_USE).size());
        model.addAttribute("availableAssets", assetService.getByStatus(AssetStatus.AVAILABLE).size());
        model.addAttribute("totalEmployees", employeeService.getAll().size());

        return "index";
    }
}