package io.github.loveyourmaryme.wordle_backend.model;

public class DictionaryEntry {

    private final char[] word;
    private final String definiton;

    public DictionaryEntry(String word, String definiton) {
        this.word = word.toCharArray();
        this.definiton = definiton;
    }

    public char[] getWord() {
        return word;
    }

    public String getDefiniton() {
        return definiton;
    }

}
