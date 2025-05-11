package io.github.loveyourmaryme.wordle_backend.model;

public class WordAnalyzer {


    public WordAnalyzer() {
    }

    public static boolean isLetterInCorrectPosition(char[] guess, char[] word, int indexWord) {

        boolean letterIsGuessed = false;

        if (guess[indexWord] == word[indexWord]) {
            letterIsGuessed = true;
        }
        return letterIsGuessed;
    }

    public static boolean isLetterInWord(char letterGuess, char[] randomWord) {

        boolean letterIsInWord = false;

        for (int i = 0; i < randomWord.length; i++) {

            if (randomWord[i] == letterGuess) {
                letterIsInWord = true;
            }
        }

        return letterIsInWord;
    }

    public static int countOccurrencesInWord(char letterGuess, char[] word) {
        int numberOfLetter = 0;

        for (int i = 0; i < word.length; i++) {
            if (word[i] == letterGuess) {
                numberOfLetter++;
            }
        }

        return numberOfLetter;
    }
}
