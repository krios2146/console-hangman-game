package org.petproject;

import java.util.*;

public class HangmanGameImpl implements HangmanGame {

    private final HangmanInterfaceImpl hangmanInterface = new HangmanInterfaceImpl();

    private final ArrayList<String> words = new ArrayList<>(Arrays.asList("avavia", "arera", "pathixile", "mirrror"));

    private String hiddenWord;

    private int mistakesCounter = 0;

    private boolean isPlayerWin = false;
    private boolean isPlayerLose = false;

    private final Map<Integer, Character> letters = new HashMap<>();
    private final List<String> suggestedLetters = new ArrayList<>();

    @Override
    public void initiateGame() {
        String personAnswer = hangmanInterface.askPersonToPlay();

        if (personAnswer.equalsIgnoreCase("Y")) {
            prepareGame();
        }

        if (personAnswer.equalsIgnoreCase("N")) {
            exitGame();
        }

    }

    @Override
    public void playGame() {
        hangmanInterface.drawInterface(hiddenWord);

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == charToDraw) {
                letters.put(i, charToDraw);
            }
        }

        if (letters.size() == word.length()) {
            isPlayerWin = true;
        }

        drawHangman.drawHangman(mistakesCounter);

        drawLetters.drawLetters(' ');
        while (!isPlayerLose) {
            while (suggestedLetters.contains(suggestedLetter)) {
                System.out.println("You're already suggest this letter, try the new one");
                suggestedLetter = String.valueOf(input.nextLine().charAt(0));
            }
            suggestedLetters.add(suggestedLetter);

            if (!word.contains(suggestedLetter)) {
                mistakesCounter++;
            }
            drawHangman.drawHangman(mistakesCounter);
            drawLetters.drawLetters(suggestedLetter.charAt(0));
            if (mistakesCounter == 6) {
                isPlayerLose = true;
                System.out.println("You're lost");
            }
        }
    }

    @Override
    public void endGame() {
        hangmanInterface.endGame();
    }

    @Override
    public void exitGame() {
        hangmanInterface.exitGame();
    }

    private void prepareGame() {
        int randomNumber = new Random().nextInt(0, words.size());
        hiddenWord = words.get(randomNumber);
        hangmanInterface.drawInterface(hiddenWord);
        playGame();
    }
}
