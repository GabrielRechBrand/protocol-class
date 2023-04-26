import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        Object object = registry.lookup("messages");

        IRemote remote = (IRemote) object;
        System.out.println("Message received: " + remote.getMessage());
        remote.setMessage("Hello from client!");
    }
}