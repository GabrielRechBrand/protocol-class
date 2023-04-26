import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) {
        try {
            String serviceName = "messages";
            ICalculator remote = new CalculatorImpl();
            ICalculator stub = (ICalculator) UnicastRemoteObject.exportObject(remote, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind(serviceName, stub);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}