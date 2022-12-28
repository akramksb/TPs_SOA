package me.enset.contraventioncommandservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.enset.core.command.NewContraventionCommand;
import me.enset.core.event.VehicleOverSpeedDetectedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OverSpeedEventHandler {

    private final CommandGateway commandGateway;


    @EventHandler
    public void on(VehicleOverSpeedDetectedEvent event) {
        log.info("+++++VehicleOverSpeedDetectedEvent occured");
        commandGateway.send(new NewContraventionCommand(
                event.getContraventionId(),
                event.getPayload()
        ));

    }
}
