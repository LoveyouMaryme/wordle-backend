package io.github.loveyourmaryme.wordle_backend.model;

public class Affichage {


    public static String formatSuffixes(int numberOfGuesses) {

        String suffixNumber;

        switch(numberOfGuesses) {
            case 1:
                suffixNumber = "st";
                break;
            case 2:
                suffixNumber = "nd";
                break;
            case 3:
                suffixNumber = "rd";
                break;
            default:
                suffixNumber = "th";
        }

        return suffixNumber;
    }
}
