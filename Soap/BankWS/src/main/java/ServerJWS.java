import jakarta.xml.ws.Endpoint;
import ws.BankService;

public class ServerJWS {
    public static void main(String[] args) {
        Endpoint.publish("http://0.0.0.0:8089/", new BankService());
        System.out.println("WS déployé sur http://0.0.0.0:8089/");
    }
}
