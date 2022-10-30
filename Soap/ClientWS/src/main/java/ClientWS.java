import proxy.BankService;
import proxy.BankWs;
import proxy.Compte;

public class ClientWS {
    public static void main(String[] args) {
        BankService stub = new BankWs().getBankServicePort();
        System.out.println( stub.convert(10) );
        Compte cp = stub.getCompte(5);
        System.out.println(cp.getCode());
        System.out.println(cp.getSolde());
        System.out.println(cp.getDateCreation());
    }
}
