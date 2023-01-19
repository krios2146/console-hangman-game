package org.petproject;

import java.util.HashMap;
import java.util.Map;

public class DrawLettersImpl implements DrawLetters {

    @Override
    public void drawLetters(String word) {
        Map<Integer, Character> letters = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            letters.put(i, word.charAt(i));
        }

        drawEmptyLetters(word);
    }

    private void drawEmptyLetters(String word) {
        int amountOfEmptyLetters = word.length();
        System.out.println("");
        System.out.println("Letters: ");
        for (int i = 0; i < amountOfEmptyLetters; i++) {
            System.out.print("---  ");
        }
        System.out.println("");
        for (int i = 0; i < amountOfEmptyLetters; i++) {
            System.out.print("| |  ");
        }
        System.out.println("");
        for (int i = 0; i < amountOfEmptyLetters; i++) {
            System.out.print("---  ");
        }
    }
}
