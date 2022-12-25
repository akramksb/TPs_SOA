package ma.enset.comptecqrses.commonapi.query.service;

import ma.enset.comptecqrses.commonapi.events.AccountCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceHandler {
    @EventHandler
    public void on(AccountCreatedEvent event){
        
    }
}
