package com.airtel_managment_system.service;

import com.airtel_managment_system.model.Asset;
import com.airtel_managment_system.model.AssetStatus;
import com.airtel_managment_system.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository repository;

    public AssetService(AssetRepository repository) {
        this.repository = repository;
    }

    public Asset save(Asset asset) {
        return repository.save(asset);
    }

    public List<Asset> getAll() {
        return repository.findAll();
    }

    public List<Asset> getByStatus(AssetStatus status) {
        return repository.findByStatus(status);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}