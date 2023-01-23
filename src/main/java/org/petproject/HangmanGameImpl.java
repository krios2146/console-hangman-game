package org.petproject;

import java.util.*;

public class HangmanGameImpl implements HangmanGame {

    private final HangmanInterfaceImpl hangmanInterface = new HangmanInterfaceImpl();

    private final ArrayList<String> words = new ArrayList<>(Arrays.asList("avavia", "arera", "pathixile", "mirrror"));

    private String hiddenWord;
    private int mistakesCounter;
    private boolean isPlayerLose;
    private Map<Integer, Character> lettersIndices;
    private List<Character> suggestedLetters = new ArrayList<>();

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
        String suggestedLetter = hangmanInterface.askLetter();

        if (hiddenWord.contains(suggestedLetter)) {
            refreshIndicesMap(suggestedLetter.charAt(0));
        }
        if (!hiddenWord.contains(suggestedLetter)) {
            mistakesCounter++;
        }

        hangmanInterface.drawInterface(mistakesCounter);

        boolean isGameEnded = checkIfGameIsEnded();

        if (!isGameEnded) {
            playGame();
        }
    }

    @Override
    public void endGame(boolean isPlayerLose) {
        hangmanInterface.endGame(isPlayerLose);
        initiateGame();
    }

    @Override
    public void exitGame() {
        hangmanInterface.exitGame();
    }

    private boolean checkIfGameIsEnded() {
        // lose
        if (mistakesCounter == 6) {
            isPlayerLose = true;
            endGame(isPlayerLose);
            return true;
        }
        // win
        if (lettersIndices.size() == hiddenWord.length()) {
            endGame(isPlayerLose);
            return true;
        }
        return false;
    }

    private void refreshIndicesMap(Character letter) {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter) {
                lettersIndices.put(i, letter);
            }
        }
        hangmanInterface.setLettersIndexes(lettersIndices);
    }

    private void prepareGame() {
        // refresh class variables
        int randomNumber = new Random().nextInt(0, words.size());
        hiddenWord = words.get(randomNumber);
        isPlayerLose = false;
        mistakesCounter = 0;
        lettersIndices = new HashMap<>();

        // initial variables setup
        hangmanInterface.setHiddenWord(hiddenWord);
        hangmanInterface.setLettersIndexes(lettersIndices);

        hangmanInterface.drawInterface(mistakesCounter);

        playGame();
    }
}
