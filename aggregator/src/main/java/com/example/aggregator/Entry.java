package com.example.aggregator;

public class Entry {
    private String word;
    private String definition;

    public Entry(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    // Getters and setters
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}