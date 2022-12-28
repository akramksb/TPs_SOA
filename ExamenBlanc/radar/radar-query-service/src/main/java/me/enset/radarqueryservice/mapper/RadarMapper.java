package me.enset.radarqueryservice.mapper;

import me.enset.core.dto.*;
import me.enset.radarqueryservice.entity.OverSpeedDetection;
import me.enset.radarqueryservice.entity.Radar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RadarMapper {
    Radar from(RadarDTO radarDTO);
    RadarResponseDTO from(Radar radar);
    RadarOverSpeedsDTO fromRadar(Radar radar);
    OverSpeedDetection from(OverSpeedRequestDTO overSpeedRequestDTO);
    OverSpeedResponseDTO fromOS(OverSpeedDetection overSpeedRequest);
}
