package com.parking.parkingmanagementsystemapplication.service;

import com.parking.parkingmanagementsystemapplication.model.ParkingSpot;
import com.parking.parkingmanagementsystemapplication.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {
    @Autowired
    private ParkingSpotRepository repository;

    public List<ParkingSpot> findAll() {
        return repository.findAll();
    }

    public ParkingSpot save(ParkingSpot spot) {
        return repository.save(spot);
    }
}

