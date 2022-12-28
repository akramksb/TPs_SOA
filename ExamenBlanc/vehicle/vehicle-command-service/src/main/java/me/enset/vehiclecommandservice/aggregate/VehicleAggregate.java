package me.enset.vehiclecommandservice.aggregate;

import lombok.extern.slf4j.Slf4j;
import me.enset.core.command.CreateVehicleCommand;
import me.enset.core.command.UpdateVehicleCommand;
import me.enset.core.command.UpdateVehicleOwnerCommand;
import me.enset.core.dto.UpdateVehicleOwnerRequestDTO;
import me.enset.core.dto.VehicleRequestDTO;
import me.enset.core.enums.VehicleType;
import me.enset.core.event.VehicleCreatedEvent;
import me.enset.core.event.VehicleOwnerUpdatedEvent;
import me.enset.core.event.VehicleUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;


@Slf4j
@Aggregate
public class VehicleAggregate {

    @AggregateIdentifier
    private String registrationNumber;
    private VehicleType type;
    private String brand;
    private String model;
    private int fiscalPower;
    private String ownerId;
    private String ownerName;
    private String ownerNationalIdCard;
    private String ownerEmail;
    private String ownerPhoneNumber;
    private String ownerAddress;

    public VehicleAggregate() {

    }

    @CommandHandler
    public VehicleAggregate(CreateVehicleCommand command) {
        AggregateLifecycle.apply(new VehicleCreatedEvent(
                command.getId(),
                command.getPayload()
        ));
    }

    @EventSourcingHandler
    public void on(VehicleCreatedEvent event) {
        updateVehicle(event.getPayload(), event.getId());
    }

    @CommandHandler
    public VehicleAggregate(UpdateVehicleCommand command) {
        AggregateLifecycle.apply(new VehicleUpdatedEvent(
                command.getId(),
                command.getPayload()
        ));
    }

    @EventSourcingHandler
    public void on(VehicleUpdatedEvent event) {
        updateVehicle(event.getPayload(), event.getId());
    }

    private void updateVehicle(VehicleRequestDTO payload2, String id) {
        VehicleRequestDTO payload = payload2;
        registrationNumber = id;
        type = payload.getType();
        brand = payload.getBrand();
        model = payload.getModel();
        fiscalPower = payload.getFiscalPower();
        ownerId = payload.getOwnerId();
        ownerName = payload.getOwnerName();
        ownerNationalIdCard = payload.getOwnerNationalIdCard();
        ownerEmail = payload.getOwnerEmail();
        ownerPhoneNumber = payload.getOwnerPhoneNumber();
        ownerAddress = payload.getOwnerAddress();
    }

    @CommandHandler
    public void on(UpdateVehicleOwnerCommand command) {
        AggregateLifecycle.apply(new VehicleOwnerUpdatedEvent(
                command.getId(),
                command.getPayload()
        ));
    }

    @EventSourcingHandler
    public void on(VehicleOwnerUpdatedEvent event) {
        UpdateVehicleOwnerRequestDTO payload = event.getPayload();

        ownerId = payload.getOwnerId();
        ownerName = payload.getOwnerName();
        ownerNationalIdCard = payload.getOwnerNationalIdCard();
        ownerEmail = payload.getOwnerEmail();
        ownerPhoneNumber = payload.getOwnerPhoneNumber();
        ownerAddress = payload.getOwnerAddress();
    }

}
