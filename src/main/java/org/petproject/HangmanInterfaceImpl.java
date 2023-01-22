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

        drawHangman(0);
        drawLetterBoxes();
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

    private void drawHangman(int mistakes) {
        drawHangmanHead(mistakes);
        drawHangmanBody(mistakes);
        drawHangmanLegs(mistakes);
    }

    private void drawHangmanHead(int mistakes) {
        // part of hangman device
        System.out.println("=======================");
        System.out.println(" ||              |     ");
        if (mistakes > 0) {
            System.out.println(" ||             ***    ");
            System.out.println(" ||             ***    ");
        } else {
            drawHangmanEmptyLine(2);
        }
    }

    private void drawHangmanBody(int mistakes) {
        if (mistakes < 2) {
            drawHangmanEmptyLine(3);
        }
        if (mistakes >= 2) {
            System.out.println(" ||              |     ");
            if (mistakes == 2) {
                System.out.println(" ||              |     ");
            }
            if (mistakes == 3) {
                System.out.println(" ||          ----|     ");
            }
            if (mistakes >= 4) {
                System.out.println(" ||          ----|---- ");
            }
            System.out.println(" ||              |     ");
        }
    }

    private void drawHangmanLegs(int mistakes) {
        if (mistakes < 5) {
            drawHangmanEmptyLine(2);
        }
        if (mistakes == 5) {
            System.out.println(" ||             /      ");
            System.out.println(" ||            /       ");
        }
        if (mistakes > 5) {
            System.out.println(" ||             / \\   ");
            System.out.println(" ||            /   \\  ");
        }
        drawHangmanEmptyLine(2);
    }

    private void drawHangmanEmptyLine(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(" ||                    ");
        }
    }

    private void drawLetterBoxes() {
        drawHorizontalLetterBoxBorders();
        drawVerticalLetterBoxBorders();
        drawHorizontalLetterBoxBorders();
    }

    private void drawHorizontalLetterBoxBorders() {
        for (int i = 0; i < amountOfLettersInWord; i++) {
            System.out.print("---  ");
            if (i == amountOfLettersInWord) {
                System.out.print("---");
                System.out.println();
            }
        }
    }

    private void drawVerticalLetterBoxBorders() {
        for (int i = 0; i < amountOfLettersInWord; i++) {
            System.out.print("| |  ");
            if (i == amountOfLettersInWord) {
                System.out.print("| |");
                System.out.println();
            }
        }
    }
}
