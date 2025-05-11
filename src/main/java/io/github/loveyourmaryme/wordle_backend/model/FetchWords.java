package io.github.loveyourmaryme.wordle_backend.model;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FetchWords {

    public static final String DICTIONARY_FILE = "ressources/data/dict.csv";
    public DictionaryEntry[] dictionary;

    private int numberOfLetters;

    public FetchWords(int numberOfLetters) {
        this.numberOfLetters = numberOfLetters;
    }

    public ArrayList<DictionaryEntry> readDictionary(String filename) {

        String currentWord;
        String word;
        String definition;
        CSVReader csvReader;
        ArrayList<DictionaryEntry> words = new ArrayList<>();


        try {

            csvReader = new CSVReaderBuilder(new FileReader(filename))
                    .withCSVParser(new CSVParserBuilder()
                            .withSeparator(',')
                            .withQuoteChar('"')
                            .build())
                    .withSkipLines(1)
                    .build();


            while (csvReader.readNext() != null) {

                currentWord = Arrays.toString(csvReader.readNext());

                word = currentWord.substring(0, currentWord.indexOf(",")).replaceAll("\\[", "").toLowerCase();
                definition = currentWord.substring(currentWord.indexOf(",") + 2).replaceAll("]", "");
                ;

                DictionaryEntry newWord = new DictionaryEntry(word, definition);

                if (word.length() == this.numberOfLetters) {
                    words.add(newWord);

                }
            }
            csvReader.close();


        } catch (FileNotFoundException e) {
            System.out.println("The file was not found ):" + e);

        } catch (IOException e) {
            System.out.println("Bad reading");

        } catch (CsvValidationException e) {
            System.out.println("Csv has an issue");
        }

        return words;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public DictionaryEntry[] getDictionary() {
        return dictionary;
    }
}
