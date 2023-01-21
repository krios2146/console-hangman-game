package org.petproject;

import java.util.Scanner;

public class HangmanInterfaceImpl implements HangmanInterface {

    private int amountOfLettersInWord;
    private final Scanner input = new Scanner(System.in);

    @Override
    public String askPersonToPlay() {
        System.out.println("Do you want to play the hangman game? (Y/N)");
        return String.valueOf(input.nextLine().charAt(0));
    }

    @Override
    public void drawInterface(String word) {
        amountOfLettersInWord = word.length();

        System.out.println();
        System.out.println("Letters: ");

        drawLetterBox();
    }

    @Override
    public void drawInterface(int mistakes) {

    }

    @Override
    public void drawInterface(Character letter) {

    }

    @Override
    public String askLetter() {
        System.out.print("Suggest a letter for the hidden word: ");
        return input.nextLine();
    }

    @Override
    public void endGame() {
        System.out.println("Game is over");
    }

    @Override
    public void exitGame() {
        System.out.println("Exiting");
    }

    private void drawLetterBox() {
        drawHorizontalLetterBoxBorder();
        drawVerticalLetterBoxBorder();
        drawHorizontalLetterBoxBorder();
    }

    private void drawHorizontalLetterBoxBorder() {
        for (int i = 0; i < amountOfLettersInWord; i++) {
            System.out.print("---  ");
            if (i == amountOfLettersInWord) {
                System.out.print("---");
                System.out.println();
            }
        }
    }

    private void drawVerticalLetterBoxBorder() {
        for (int i = 0; i < amountOfLettersInWord; i++) {
            System.out.print("| |  ");
            if (i == amountOfLettersInWord) {
                System.out.print("| |");
                System.out.println();
            }
        }
    }
}
