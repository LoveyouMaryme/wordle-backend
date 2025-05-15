package io.github.loveyourmaryme.wordle_backend.controller;

import io.github.loveyourmaryme.wordle_backend.model.DictionaryEntry;
import io.github.loveyourmaryme.wordle_backend.model.PlayerGuess;
import io.github.loveyourmaryme.wordle_backend.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class GameController {

    int numberOfLetters;
    boolean isGameContinuing = true;
    PlayerGuess playerChoice;
    boolean wordIsFound = false;
    String defintionRandomWord = "";

    private final GameService gameService;


    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping(value = "/askLetters")
    public  DictionaryEntry retrieveRandomWord(int numberOfGuesses) {
        return gameService.randomWord(numberOfGuesses);
    }

    @PostMapping(value = "/askIsGameDone")
    public  boolean askIsGameDone(String responsePlayer) {
        return gameService.askIsGameDone(responsePlayer);
    }


    @PostMapping(value = "/askPlayerGuess")
    public PlayerGuess retrievePlayerGuess(char[] playerGuess) {
        return gameService.askPlayerGuess(playerGuess);
    }


}
