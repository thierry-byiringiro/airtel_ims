package com.airtel_managment_system.repository;


import com.airtel_managment_system.model.Asset;
import com.airtel_managment_system.model.AssetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByStatus(AssetStatus status);
}