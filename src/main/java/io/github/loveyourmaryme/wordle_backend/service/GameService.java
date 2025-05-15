package io.github.loveyourmaryme.wordle_backend.service;

import io.github.loveyourmaryme.wordle_backend.model.DictionaryEntry;
import io.github.loveyourmaryme.wordle_backend.model.FetchWords;
import io.github.loveyourmaryme.wordle_backend.model.PlayerGuess;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static io.github.loveyourmaryme.wordle_backend.model.AskPlayerQuestions.askNumberOfLetters;

@Service
public class GameService {

    int numberOfLetters;
    boolean isGameContinuing = true;
    PlayerGuess playerChoice;
    boolean wordIsFound = false;
    String defintionRandomWord = "";

    public  DictionaryEntry randomWord(int numberOfGuesses) {
        ArrayList<DictionaryEntry> availableWords;
        int randomNumber;
        DictionaryEntry randomWord;

        availableWords = new FetchWords(numberOfGuesses).readDictionary(FetchWords.DICTIONARY_FILE);
        randomNumber = (int) (Math.random() * availableWords.size());

        randomWord = availableWords.get(randomNumber);
        return randomWord;
    }

    public  boolean askIsGameDone(String responsePlayer) {
        boolean isGameDone = false;

        if (responsePlayer.trim().equalsIgnoreCase("yes")) {
            isGameDone = true;
        }

        return isGameDone;

    }

    public  PlayerGuess askPlayerGuess(char[] randomWordToGuess) {
        PlayerGuess playerOfficialGuess;

        playerOfficialGuess = new PlayerGuess(randomWordToGuess);

        return playerOfficialGuess;

    }


}
