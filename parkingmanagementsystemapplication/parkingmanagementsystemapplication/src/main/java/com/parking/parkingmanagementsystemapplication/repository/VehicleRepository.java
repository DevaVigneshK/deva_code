package com.parking.parkingmanagementsystemapplication.repository;

import com.parking.parkingmanagementsystemapplication.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {}