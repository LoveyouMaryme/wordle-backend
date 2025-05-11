package io.github.loveyourmaryme.wordle_backend.model;

public class GuessManager {

    private final int numberOfGuesses;
    private final PlayerGuess[] playerGuessesBank;

    public GuessManager(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
        this.playerGuessesBank = new PlayerGuess[numberOfGuesses];
    }

    public boolean addGuess (PlayerGuess guess ){
        boolean isGuessadded = false;

        for(int i = 0; i < playerGuessesBank.length && !isGuessadded; i++){

            if(playerGuessesBank[i] == null){
                playerGuessesBank[i] = guess;
                isGuessadded = true;

            }
        }

        return isGuessadded;
    }

    public PlayerGuess[] getPlayerGuessesBank() {
        return playerGuessesBank;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }
}

