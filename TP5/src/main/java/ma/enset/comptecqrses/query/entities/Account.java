package ma.enset.comptecqrses.query.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.comptecqrses.commonapi.enums.AccountStatus;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class Account {
    @Id
    private String id;
    private double balance;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private String currency;
    @OneToMany(mappedBy = "account")
    private Collection<Operation> operations;
}
