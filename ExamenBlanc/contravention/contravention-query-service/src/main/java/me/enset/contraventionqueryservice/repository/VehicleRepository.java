package me.enset.contraventionqueryservice.repository;

import me.enset.contraventionqueryservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Optional<Vehicle> findByRegistrationNumber(String matriculation);
}
