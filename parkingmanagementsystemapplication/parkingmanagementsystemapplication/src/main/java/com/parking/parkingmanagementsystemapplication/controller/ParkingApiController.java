package com.parking.parkingmanagementsystemapplication.controller;

import com.parking.parkingmanagementsystemapplication.model.ParkingSpot;
import com.parking.parkingmanagementsystemapplication.model.Vehicle;
import com.parking.parkingmanagementsystemapplication.service.ParkingService;
import com.parking.parkingmanagementsystemapplication.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParkingApiController {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/spots")
    public List<ParkingSpot> getAllSpots() {
        return parkingService.findAll();
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.findAll();
    }

    @PostMapping("/add-spot")
    public ParkingSpot addSpot(@RequestBody ParkingSpot spot) {
        return parkingService.save(spot);
    }

    @PostMapping("/add-vehicle")
    public String addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @DeleteMapping("/remove-vehicle/{id}")
    public void removeVehicle(@PathVariable Long id) {
        vehicleService.delete(id);
    }
}
