package org.petproject;

import java.util.Scanner;

public class HangmanImpl implements Hangman {

    private final Scanner input = new Scanner(System.in);

    @Override
    public void game() {
        System.out.println("Wanna game? (Y/N)");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            new DrawHangmanImpl().drawHangman();
            new DrawLettersImpl().drawLetters("avaviva");
        }
        if (answer.equalsIgnoreCase("N")) {
            System.out.println("Ok");
        }
    }
}
