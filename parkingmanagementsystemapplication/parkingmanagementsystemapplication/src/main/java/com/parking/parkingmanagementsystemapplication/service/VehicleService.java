package com.parking.parkingmanagementsystemapplication.service;

import com.parking.parkingmanagementsystemapplication.model.ParkingSpot;
import com.parking.parkingmanagementsystemapplication.model.Vehicle;
import com.parking.parkingmanagementsystemapplication.repository.ParkingSpotRepository;
import com.parking.parkingmanagementsystemapplication.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public String saveVehicle(Vehicle vehicle) {
        Long spotId = vehicle.getParkingSpot().getId();
        Optional<ParkingSpot> optionalSpot = parkingSpotRepository.findById(spotId);

        if (optionalSpot.isPresent()) {
            ParkingSpot spot = optionalSpot.get();

            if (spot.isOccupied()) {
                return "Spot " + spot.getSpotNumber() + " is already full.";
            }

            spot.setOccupied(true);
            parkingSpotRepository.save(spot);

            vehicle.setParkingSpot(spot);
            vehicleRepository.save(vehicle);

            return "Vehicle parked successfully.";
        } else {
            return "Selected parking spot not found.";
        }
    }

    public void delete(Long id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

        if (vehicleOptional.isPresent()) {
            Vehicle vehicle = vehicleOptional.get();
            ParkingSpot spot = vehicle.getParkingSpot();

            if (spot != null) {
                spot.setOccupied(false);
                parkingSpotRepository.save(spot);
            }

            vehicleRepository.deleteById(id);
        }
    }
}
