package main.java;

import java.rmi.Remote;

public interface IDictionary extends Remote {

    String getMeaning(String word) throws Exception;
    void addWord(String word, String meaning) throws Exception;
    void removeWord(String word) throws Exception;
    void updateWord(String word, String meaning) throws Exception;

}
