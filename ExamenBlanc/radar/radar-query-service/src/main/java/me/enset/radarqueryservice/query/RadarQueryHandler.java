package me.enset.radarqueryservice.query;

import lombok.AllArgsConstructor;
import me.enset.core.dto.RadarResponseDTO;
import me.enset.core.query.GetAllRadarsQuery;
import me.enset.core.query.GetRadarById;
import me.enset.radarqueryservice.mapper.RadarMapper;
import me.enset.radarqueryservice.repository.OverSpeedDetectionRepository;
import me.enset.radarqueryservice.repository.RadarRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RadarQueryHandler {

    private RadarRepository radarRepository;
    private OverSpeedDetectionRepository overSpeedDetectionRepository;
    private RadarMapper radarMappers;

    @QueryHandler
    public List<RadarResponseDTO> handler(GetAllRadarsQuery query){
        return radarRepository
                .findAll()
                .stream()
                .map(radar->radarMappers.from(radar))
                .collect(Collectors.toList());
    }

    @QueryHandler
    public RadarResponseDTO getRadarById(GetRadarById query){
        return radarRepository.findById(query.getRadarId())
                .map( radar -> radarMappers.from(radar))
                .orElse(null);
    }
}
