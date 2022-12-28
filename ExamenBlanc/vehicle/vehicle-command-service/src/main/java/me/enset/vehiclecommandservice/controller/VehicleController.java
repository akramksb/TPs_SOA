package me.enset.vehiclecommandservice.controller;

import lombok.AllArgsConstructor;
import me.enset.core.command.CreateVehicleCommand;
import me.enset.core.command.UpdateVehicleCommand;
import me.enset.core.command.UpdateVehicleOwnerCommand;
import me.enset.core.dto.UpdateVehicleOwnerRequestDTO;
import me.enset.core.dto.VehicleRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/vehicle/command")
@AllArgsConstructor
@CrossOrigin("*")
public class VehicleController {

    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public CompletableFuture<String> createNewVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO){
        return commandGateway.send(new CreateVehicleCommand(
                UUID.randomUUID().toString(),
                vehicleRequestDTO
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO){
        return commandGateway.send(new UpdateVehicleCommand(
                vehicleRequestDTO.getRegistrationNumber(),
                vehicleRequestDTO
        ));
    }

    @PostMapping("/updateOwner")
    public CompletableFuture<String> updateVehicleOwner(@RequestBody UpdateVehicleOwnerRequestDTO vehicleRequestDTO){
        return commandGateway.send(new UpdateVehicleOwnerCommand(
                vehicleRequestDTO.getRegistrationNumber(),
                vehicleRequestDTO
        ));
    }
}
