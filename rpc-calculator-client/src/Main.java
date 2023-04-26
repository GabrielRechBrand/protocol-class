import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        Object object = registry.lookup("messages");

        ICalculator remote = (ICalculator) object;
        int x = Integer.parseInt(JOptionPane.showInputDialog("X value: "));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Y value: "));

        System.out.println("Addition: " + remote.add(x, y));
        System.out.println("Subtraction: " + remote.subtract(x, y));
        System.out.println("Multiplication: " + remote.multiply(x, y));
        System.out.println("Division: " + remote.divide(x, y));

        System.out.println("Done!");
    }
}