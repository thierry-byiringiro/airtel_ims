package com.airtel_managment_system.controller;


import com.airtel_managment_system.model.Asset;
import com.airtel_managment_system.model.AssetStatus;
import com.airtel_managment_system.service.AssetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assets")
public class AssetController {

    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    // LIST PAGE
    @GetMapping
    public String list(Model model) {
        model.addAttribute("assets", service.getAll());
        return "assets";
    }

    // FORM PAGE
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("asset", new Asset());
        return "asset-form";
    }

    // SAVE
    @PostMapping("/save")
    public String save(@ModelAttribute Asset asset) {
        asset.setStatus(AssetStatus.AVAILABLE);
        service.save(asset);
        return "redirect:/assets";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/assets";
    }
}