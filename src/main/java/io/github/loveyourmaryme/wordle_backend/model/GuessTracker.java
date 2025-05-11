package io.github.loveyourmaryme.wordle_backend.model;

import java.util.ArrayList;

public class GuessTracker {

    private char[] goodGuessesTracker;
    private ArrayList<Character> badGuessesTracker;


    public GuessTracker(DictionaryEntry randomWord) {
        this.goodGuessesTracker = new char[randomWord.getWord().length];
        this.badGuessesTracker = new ArrayList<Character>();

    }

    public char[] getGoodGuessesTracker() {
        return goodGuessesTracker;
    }

    public char[] keepTrackGoodGuesses(char[] randomWord, char[] playerGuess) {

        for (int i = 0; i < randomWord.length; i++) {
            if (!(goodGuessesTracker[i] >= 'a' && goodGuessesTracker[i] <= 'z')) {
                goodGuessesTracker[i] = '_';
            }

            if (randomWord[i] == playerGuess[i]) {
                goodGuessesTracker[i] = playerGuess[i];
            }
        }
        return goodGuessesTracker;
    }

    public ArrayList<Character> keepTrackBadGuesses(char[] randomWord, char[] playerGuess) {

        for (int i = 0; i < randomWord.length; i++) {
            if (!WordAnalyzer.isLetterInWord(playerGuess[i], randomWord)) {
                if (!badGuessesTracker.contains(playerGuess[i])) {
                    badGuessesTracker.add(playerGuess[i]);
                }
            }
        }
        return badGuessesTracker;
    }

    public boolean isTheWordFound(char[] randomWord, char[] playerGuess) {
        boolean wordIsFound = true;

        for (int i = 0; i < randomWord.length && wordIsFound; i++) {
            if (randomWord[i] != playerGuess[i]) {
                goodGuessesTracker[i] = playerGuess[i];
                wordIsFound = false;
            }
        }

        if (wordIsFound) {
            System.out.println("Congratz!");
        }

        return wordIsFound;
    }
}
