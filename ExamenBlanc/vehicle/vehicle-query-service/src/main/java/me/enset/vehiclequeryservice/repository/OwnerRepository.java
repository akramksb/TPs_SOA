package me.enset.vehiclequeryservice.repository;

import me.enset.vehiclequeryservice.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}
