import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) {
        try {
            String serviceName = "messages";
            IRemote remote = new RemoteImpl();
            IRemote stub = (IRemote) UnicastRemoteObject.exportObject(remote, 1099);

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            registry.bind(serviceName, stub);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}