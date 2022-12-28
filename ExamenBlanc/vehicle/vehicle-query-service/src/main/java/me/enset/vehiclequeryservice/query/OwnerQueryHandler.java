package me.enset.vehiclequeryservice.query;


import lombok.AllArgsConstructor;
import me.enset.core.query.GetAllOwners;
import me.enset.core.query.GetAllVehiclesQuery;
import me.enset.vehiclequeryservice.entity.Owner;
import me.enset.vehiclequeryservice.repository.OwnerRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerQueryHandler {

    private final OwnerRepository ownerRepository;

    @QueryHandler
    public List<Owner> getAllOwners(GetAllOwners query){
        return ownerRepository.findAll();
    }
}
