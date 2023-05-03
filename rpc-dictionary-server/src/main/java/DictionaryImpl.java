package main.java;

import java.util.HashMap;

public class DictionaryImpl implements IDictionary {

    private final HashMap<String, String> dictionary;

    public DictionaryImpl(HashMap<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public String getMeaning(String word) {
        return dictionary.get(word);
    }

    @Override
    public void addWord(String word, String meaning) {
        dictionary.put(word, meaning);
    }

    @Override
    public void removeWord(String word) {
        dictionary.remove(word);
    }

    @Override
    public void updateWord(String word, String meaning) {
        dictionary.put(word, meaning);
    }

}
