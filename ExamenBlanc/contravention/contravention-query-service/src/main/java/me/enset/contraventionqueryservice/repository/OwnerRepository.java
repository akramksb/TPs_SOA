package me.enset.contraventionqueryservice.repository;

import me.enset.contraventionqueryservice.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}
