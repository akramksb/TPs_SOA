package me.enset.vehiclequeryservice.repository;

import me.enset.vehiclequeryservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
