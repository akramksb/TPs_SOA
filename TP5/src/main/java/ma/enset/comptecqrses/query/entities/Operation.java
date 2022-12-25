package ma.enset.comptecqrses.commonapi.query.entities;

import ma.enset.comptecqrses.commonapi.enums.OperationType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Operation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private double amount;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    @ManyToOne
    private Account account;
}
