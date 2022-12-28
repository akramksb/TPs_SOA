package me.enset.radarqueryservice.repository;

import me.enset.radarqueryservice.entity.OverSpeedDetection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OverSpeedDetectionRepository extends JpaRepository<OverSpeedDetection, String> {
}
