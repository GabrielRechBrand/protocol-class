package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        File file = new File("src/main/resources/dictionary.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String wordInPortuguese = parts[0].trim();
                String wordInEnglish = parts[1].trim();
                dictionary.put(wordInPortuguese, wordInEnglish);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        try {
            String serviceName = "dictionary";
            IDictionary remote = new DictionaryImpl(dictionary);
            IDictionary stub = (IDictionary) UnicastRemoteObject.exportObject(remote, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind(serviceName, stub);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}