package ma.enset.comptecqrses.commonapi.commands;

public class CreditAccountCommand extends BaseCommand<String>{
    private double amount;
    private String currency;

    public CreditAccountCommand(String id, double initialBalance, String currency) {
        super(id);
        this.amount = initialBalance;
        this.currency = currency;
    }
}
