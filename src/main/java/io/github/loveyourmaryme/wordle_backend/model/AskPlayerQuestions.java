package io.github.loveyourmaryme.wordle_backend.model;

import java.util.ArrayList;
import java.util.Scanner;

public class AskPlayerQuestions {

    public static int askNumberOfLetters() {


        Scanner readNumberOfLetters = new Scanner(System.in);
        boolean goodNumberOfLetters;
        String input = "0";
        int numberOfLetters = 0;

        do {

            System.out.print("Enter the number of letters you want to guess: ");
            goodNumberOfLetters = true;
            try {
                input = readNumberOfLetters.nextLine();
                numberOfLetters = Integer.parseInt(input);
                if (numberOfLetters <= 0) {
                    goodNumberOfLetters = false;
                    System.out.println("You cannot enter a negative number");
                }
            } catch (NumberFormatException e) {
                System.out.println("You didn't enter a number. Try again.");
                goodNumberOfLetters = false;
            }

            System.out.println("\nYou chose to guess " + numberOfLetters + " letters.\n");

        } while (!goodNumberOfLetters);

        return numberOfLetters;

    }

    public static boolean askIsGameDone() {
        boolean isGameDone = false;
        Scanner responsePlayer = new Scanner(System.in);
        String input;
        boolean goodAnswer;

        do {

            System.out.print("Do you still want to play?  ");
            goodAnswer = true;
            input = responsePlayer.nextLine();

            if (!input.trim().equalsIgnoreCase("yes") && !input.trim().equalsIgnoreCase("no")) {
                System.out.println("You have to either say yes or no");
                goodAnswer = false;
            } else {
                if (input.trim().equalsIgnoreCase("no")) {
                    isGameDone = true;
                }
            }

            System.out.println();

        } while (!goodAnswer);


        return isGameDone;

    }

    public static DictionaryEntry randomWord(int numberOfGuesses) {
        ArrayList<DictionaryEntry> availableWords;
        int randomNumber;
        DictionaryEntry randomWord;

        availableWords = new FetchWords(numberOfGuesses).readDictionary(FetchWords.DICTIONARY_FILE);
        randomNumber = (int) (Math.random() * availableWords.size());

        randomWord = availableWords.get(randomNumber);
        return randomWord;
    }


    public static PlayerGuess askPlayerGuess(char[] randomWordToGuess) {
        Scanner readNumberOfLetters = new Scanner(System.in);
        boolean validGuess;
        char[] input;
        int numberOfLetters = 0;
        PlayerGuess playerOfficialGuess = null;

        do {
            System.out.printf("Enter your %d%s guess: ", PlayerGuess.getNumberOfGuesses() + 1, Affichage.formatSuffixes(PlayerGuess.getNumberOfGuesses() + 1));

            validGuess = true;
            input = readNumberOfLetters.nextLine().toCharArray();


            if (input.length != randomWordToGuess.length) {
                validGuess = false;
                System.out.println("You cannot enter a word with more or less letters than the guess");
            } else {
                playerOfficialGuess = new PlayerGuess(input);

            }


        } while (!validGuess);

        return playerOfficialGuess;

    }
}
