package com.parking.parkingmanagementsystemapplication.model;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;
    private String ownerName;

    @ManyToOne
    private ParkingSpot parkingSpot;

    public Vehicle() {}

    public Vehicle(String licensePlate, String ownerName, ParkingSpot parkingSpot) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.parkingSpot = parkingSpot;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public ParkingSpot getParkingSpot() { return parkingSpot; }
    public void setParkingSpot(ParkingSpot parkingSpot) { this.parkingSpot = parkingSpot; }
}

