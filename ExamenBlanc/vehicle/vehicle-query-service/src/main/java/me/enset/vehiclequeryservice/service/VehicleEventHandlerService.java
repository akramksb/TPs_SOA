package me.enset.vehiclequeryservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.enset.core.dto.VehicleRequestDTO;
import me.enset.core.event.VehicleCreatedEvent;
import me.enset.core.event.VehicleOwnerUpdatedEvent;
import me.enset.core.event.VehicleUpdatedEvent;
import me.enset.vehiclequeryservice.entity.Owner;
import me.enset.vehiclequeryservice.entity.Vehicle;
import me.enset.vehiclequeryservice.repository.OwnerRepository;
import me.enset.vehiclequeryservice.repository.VehicleRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class VehicleEventHandlerService {

    private VehicleRepository vehicleRepository;
    private OwnerRepository ownerRepository;

    @EventHandler
    public void on(VehicleCreatedEvent event) {
        Owner owner = null;
        VehicleRequestDTO payload = event.getPayload();
        if (!payload.getOwnerId().equals("")) {
            owner = ownerRepository.findById(payload.getOwnerId()).orElse(null);
        }

        if (owner == null) {
            owner = Owner
                    .builder()
                    .id(UUID.randomUUID().toString())
                    .ownerNationalIdCard(payload.getOwnerNationalIdCard())
                    .ownerName(payload.getOwnerName())
                    .ownerEmail(payload.getOwnerEmail())
                    .ownerPhoneNumber(payload.getOwnerPhoneNumber())
                    .ownerAddress(payload.getOwnerAddress())
                    .build();
            owner = ownerRepository.save(owner);
        }

        Vehicle vehicle = Vehicle
                .builder()
                .registrationNumber(payload.getRegistrationNumber())
                .brand(payload.getBrand())
                .type(payload.getType())
                .model(payload.getModel())
                .owner(owner)
                .build();

        vehicleRepository.save(vehicle);

    }

    @EventHandler
    public void on(VehicleUpdatedEvent event){
        Vehicle vehicle = vehicleRepository.findById(event.getId()).get();
        VehicleRequestDTO payload = event.getPayload();
        vehicle.setBrand(payload.getBrand());
        vehicle.setModel(payload.getModel());
        vehicle.setType(payload.getType());
        vehicle.setFiscalPower(payload.getFiscalPower());

        vehicleRepository.save(vehicle);
    }

    @EventHandler
    public void on(VehicleOwnerUpdatedEvent event){
        Vehicle vehicle = vehicleRepository.findById(event.getId()).get();
        Owner owner = ownerRepository.findById(event.getPayload().getOwnerId()).get();
        vehicle.setOwner(owner);
        vehicleRepository.save(vehicle);
    }
}
