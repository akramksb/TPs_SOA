package me.enset.vehiclecommandservice.aggregate;

import me.enset.core.command.CreateOwnerCommand;
import me.enset.core.command.UpdateVehicleOwnerCommand;
import me.enset.core.dto.OwnerRequestDTO;
import me.enset.core.dto.UpdateVehicleOwnerRequestDTO;
import me.enset.core.enums.VehicleType;
import me.enset.core.event.OwnerCreatedEvent;
import me.enset.core.event.VehicleOwnerUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class OwnerAggregate {

    @AggregateIdentifier
    private String ownerId;
    private String ownerName;
    private String ownerNationalIdCard;
    private String ownerEmail;
    private String ownerPhoneNumber;
    private String ownerAddress;

    public  OwnerAggregate() {}

    @CommandHandler
    public  OwnerAggregate(CreateOwnerCommand command) {
        AggregateLifecycle.apply(new OwnerCreatedEvent(
                command.getId(),
                command.getPayload()
        ));
    }

    @EventSourcingHandler
    public void on(OwnerCreatedEvent event) {
        OwnerRequestDTO payload = event.getPayload();
        ownerId = payload.getOwnerId();
        ownerName = payload.getOwnerName();
        ownerNationalIdCard = payload.getOwnerNationalIdCard();
        ownerEmail = payload.getOwnerEmail();
        ownerPhoneNumber = payload.getOwnerPhoneNumber();
        ownerAddress = payload.getOwnerAddress();
    }
}
