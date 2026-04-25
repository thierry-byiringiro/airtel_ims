package com.airtel_managment_system.model;

import javax.persistence.*;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; 
    private String serialNumber;
    private String model;
    private String department;

    @Enumerated(EnumType.STRING)
    private AssetStatus status;

    // Constructors
    public Asset() {}

    public Asset(String name, String serialNumber, String model, String department, AssetStatus status) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.model = model;
        this.department = department;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public AssetStatus getStatus() { return status; }
    public void setStatus(AssetStatus status) { this.status = status; }
}