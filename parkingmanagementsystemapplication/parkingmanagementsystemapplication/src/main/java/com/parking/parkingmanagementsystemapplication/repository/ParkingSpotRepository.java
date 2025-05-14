package com.parking.parkingmanagementsystemapplication.repository;

import com.parking.parkingmanagementsystemapplication.model.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {}