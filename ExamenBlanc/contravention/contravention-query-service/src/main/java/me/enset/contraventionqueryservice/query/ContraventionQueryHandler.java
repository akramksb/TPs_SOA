package me.enset.contraventionqueryservice.query;

import lombok.AllArgsConstructor;
import me.enset.contraventionqueryservice.entity.Contravention;
import me.enset.contraventionqueryservice.repository.ContraventionRepository;
import me.enset.core.query.GetAllContraventions;
import me.enset.core.query.GetContraventionsByNationalCardNumber;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContraventionQueryHandler {

    private ContraventionRepository contraventionRepository;

    @QueryHandler
    public List<Contravention> getAllContravention(GetAllContraventions query){
        return contraventionRepository.findAll();
    }

    @QueryHandler
    public List<Contravention> getContraventionByCIN(GetContraventionsByNationalCardNumber query){
        return contraventionRepository.findByVehicle_Owner_OwnerNationalIdCard(query.getNationalCardNumber());
    }
}
