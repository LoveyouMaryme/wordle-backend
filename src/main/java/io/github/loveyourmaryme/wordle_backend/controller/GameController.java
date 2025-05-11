package io.github.loveyourmaryme.wordle_backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class GameController {


    @PostMapping(value = "/askLetters")
    public Integer askNumberOfLetters(@RequestParam int numberOfLetters){
        return numberOfLetters;
    }





}
