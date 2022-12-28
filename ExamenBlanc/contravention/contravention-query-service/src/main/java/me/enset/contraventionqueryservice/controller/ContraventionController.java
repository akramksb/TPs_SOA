package me.enset.contraventionqueryservice.controller;


import lombok.AllArgsConstructor;
import me.enset.contraventionqueryservice.entity.Contravention;
import me.enset.core.query.GetAllContraventions;
import me.enset.core.query.GetContraventionsByNationalCardNumber;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/contraventions/query")
@AllArgsConstructor
@CrossOrigin("*")
public class ContraventionController {

    private final QueryGateway queryGateway;

    @GetMapping("/all")
    public CompletableFuture<List<Contravention>> getAll(){
        return queryGateway.query(new GetAllContraventions(0, 0),
                ResponseTypes.multipleInstancesOf(Contravention.class));
    }

    @GetMapping("/cin/{cin}")
    public CompletableFuture<List<Contravention>> getByCin(@PathVariable String cin){
        return queryGateway.query(new GetContraventionsByNationalCardNumber(cin, 0, 0),
                ResponseTypes.multipleInstancesOf(Contravention.class));
    }
}
