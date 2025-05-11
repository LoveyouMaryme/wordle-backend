package io.github.loveyourmaryme.wordle_backend.model;

public class PlayerGuess {

    private final char[] guess;
    private static int numberOfGuesses = 0;

    public PlayerGuess(char[] guess) {
        this.guess = guess;
        numberOfGuesses++;
    }

    public static int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public char[] getGuess() {
        return guess;
    }

    public static void resetNumberOfGuesses(){
        numberOfGuesses = 0;
    }
}
