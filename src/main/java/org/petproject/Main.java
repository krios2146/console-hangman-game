package org.petproject;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        new DrawHangmanImpl().drawHangman();
    }

    List<String> words = List.of("аббат", "ававива", "ареира");

    int randomNumber = new Random().nextInt(0, words.size());


}