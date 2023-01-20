package org.petproject;

import java.util.HashMap;
import java.util.Map;

public class DrawLettersImpl implements DrawLetters {

    private String word;
    private final Map<Integer, Character> letters = new HashMap<>();
    public DrawLettersImpl() {
    }

    @Override
    public void drawLetters(Character charToDraw) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == charToDraw) {
                letters.put(i, charToDraw);
            } else {
                letters.putIfAbsent(i, ' ');
            }
        }

        int amountOfLetterBoxes = word.length();
        System.out.println(" ");
        System.out.println("Letters: ");

        for (int i = 0; i < amountOfLetterBoxes; i++) {
            System.out.print("---  ");
        }
        System.out.println(" ");
        for (int i = 0; i < amountOfLetterBoxes; i++) {
            System.out.print("|" + letters.get(i) + "|  ");
        }
        System.out.println(" ");
        for (int i = 0; i < amountOfLetterBoxes; i++) {
            System.out.print("---  ");
        }
        System.out.println(" ");
    }

    public void setWord(String word) {
        this.word = word;
    }
}
