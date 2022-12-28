package me.enset.vehiclecommandservice.controller;

import lombok.AllArgsConstructor;
import me.enset.core.command.CreateOwnerCommand;
import me.enset.core.dto.OwnerRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/owner/command")
@AllArgsConstructor
@CrossOrigin("*")
public class OwnerController {

    private final CommandGateway commandGateway;

    @PostMapping
    public CompletableFuture<String> createNewOwner(@RequestBody OwnerRequestDTO ownerRequestDTO){
        return commandGateway.send(new CreateOwnerCommand(
                UUID.randomUUID().toString(),
                ownerRequestDTO
        ));
    }
}
