package org.example.homework3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String fileName = "words.txt";
        Map<String, Integer> wordFrequency = countWordFrequency(fileName);


        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static Map<String, Integer> countWordFrequency(String fileName) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");

                for (String word : words) {

                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не знайдено: " + fileName);
            e.printStackTrace();
        }

        return wordFrequency;
    }
}

