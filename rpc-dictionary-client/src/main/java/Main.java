import main.java.IDictionary;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        Object object = registry.lookup("dictionary");

        main.java.IDictionary remote = (IDictionary) object;

        while(true) {
            String word = JOptionPane.showInputDialog("Enter a word: ");
            String meaning = remote.getMeaning(word);
            JOptionPane.showMessageDialog(null, meaning);
        }
    }
}