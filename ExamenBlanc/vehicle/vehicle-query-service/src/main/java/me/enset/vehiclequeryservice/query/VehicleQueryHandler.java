package me.enset.vehiclequeryservice.query;


import lombok.AllArgsConstructor;
import me.enset.core.query.GetAllVehiclesQuery;
import me.enset.vehiclequeryservice.entity.Vehicle;
import me.enset.vehiclequeryservice.repository.VehicleRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleQueryHandler {

    private final VehicleRepository vehicleRepository;

    @QueryHandler
    public List<Vehicle> getAllVehicle(GetAllVehiclesQuery query){
        return vehicleRepository.findAll();
    }
}
