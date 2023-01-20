package org.petproject;

import java.util.*;

public class HangmanImpl implements Hangman {

    private final Scanner input = new Scanner(System.in);
    private final DrawHangmanImpl hangman = new DrawHangmanImpl();
    private final DrawLettersImpl letters = new DrawLettersImpl();
    private final ArrayList<String> words = new ArrayList<>(Arrays.asList("avavia", "arera", "pathixile", "mirrror"));

    private boolean isPlayerLost = false;
    private int mistakesCounter = 0;
    private final List<String> suggestedLetters = new ArrayList<>();

    @Override
    public void game() {
        while (true) {
            System.out.println("Wanna game? (Y/N)");
            String answer = input.nextLine();

            if (answer.equalsIgnoreCase("N")) {
                System.out.println("Ok, exiting");
                break;
            }

            if (answer.equalsIgnoreCase("Y")) {
                String word = pickWordForGame();
                hangman.drawHangman(mistakesCounter);
                letters.setWord(word);
                letters.drawLetters(' ');
                while (!isPlayerLost) {
                    System.out.print("Suggest a letter for the hidden word: ");
                    String suggestedLetter = String.valueOf(input.nextLine().charAt(0));
                    while (suggestedLetters.contains(suggestedLetter)) {
                        System.out.println("You're already suggest this letter, try the new one");
                        suggestedLetter = String.valueOf(input.nextLine().charAt(0));
                    }
                    suggestedLetters.add(suggestedLetter);

                    if (!word.contains(suggestedLetter)) {
                        mistakesCounter++;
                    }
                    hangman.drawHangman(mistakesCounter);
                    letters.drawLetters(suggestedLetter.charAt(0));
                    if (mistakesCounter == 6) {
                        isPlayerLost = true;
                        System.out.println("You're lost");
                    }
                }
            }
        }
    }

    private String pickWordForGame() {
        int randomNumber = new Random().nextInt(0, words.size());
        return words.get(randomNumber);
    }
}
