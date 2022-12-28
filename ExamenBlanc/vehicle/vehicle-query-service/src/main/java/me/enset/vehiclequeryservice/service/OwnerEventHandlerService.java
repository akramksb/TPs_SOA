package me.enset.vehiclequeryservice.service;

import lombok.AllArgsConstructor;
import me.enset.core.dto.OwnerRequestDTO;
import me.enset.core.dto.UpdateVehicleOwnerRequestDTO;
import me.enset.core.event.OwnerCreatedEvent;
import me.enset.core.event.VehicleOwnerUpdatedEvent;
import me.enset.vehiclequeryservice.entity.Owner;
import me.enset.vehiclequeryservice.repository.OwnerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OwnerEventHandlerService {
    private final OwnerRepository ownerRepository;

    @EventHandler
    public void on(OwnerCreatedEvent event){
        OwnerRequestDTO payload = event.getPayload();
        Owner owner = Owner
                .builder()
                .id(event.getId())
                .ownerName(payload.getOwnerName())
                .ownerNationalIdCard(payload.getOwnerNationalIdCard())
                .ownerAddress(payload.getOwnerAddress())
                .ownerEmail(payload.getOwnerEmail())
                .ownerPhoneNumber(payload.getOwnerPhoneNumber())
                .build();

        ownerRepository.save(owner);
    }

}
