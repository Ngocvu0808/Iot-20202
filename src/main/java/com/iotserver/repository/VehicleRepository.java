package com.iotserver.repository;

import com.iotserver.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
