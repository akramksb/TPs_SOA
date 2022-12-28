package me.enset.radarqueryservice.repository;

import me.enset.radarqueryservice.entity.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {
}
