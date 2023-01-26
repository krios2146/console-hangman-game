package org.petproject;

import java.util.*;

public class HangmanGameImpl implements HangmanGame {

    private final HangmanInterfaceImpl hangmanInterface;

    private String hiddenWord;
    private int mistakesCounter;
    private boolean isPlayerLose;
    private Map<Integer, Character> guessedLetters;
    private List<Character> previouslySuggestedLetters;

    public HangmanGameImpl() {
        this.hangmanInterface = new HangmanInterfaceImpl();
    }

    public HangmanGameImpl(HangmanInterfaceImpl hangmanInterface) {
        this.hangmanInterface = hangmanInterface;
    }

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

        while (isLetterAlreadyBeingUsed(suggestedLetter.charAt(0))) {
            hangmanInterface.alreadySuggestedLetterWarning();
            suggestedLetter = hangmanInterface.askLetter();
        }

        previouslySuggestedLetters.add(suggestedLetter.charAt(0));

        if (hiddenWord.contains(suggestedLetter)) {
            refreshGuessedLetters(suggestedLetter.charAt(0));
        }
        if (!hiddenWord.contains(suggestedLetter)) {
            mistakesCounter++;
        }

        hangmanInterface.drawInterface(mistakesCounter);

        if (!isGameOver()) {
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

    private boolean isGameOver() {
        // lose
        if (mistakesCounter == 6) {
            isPlayerLose = true;
            endGame(isPlayerLose);
            return true;
        }
        // win
        if (guessedLetters.size() == hiddenWord.length()) {
            endGame(isPlayerLose);
            return true;
        }
        return false;
    }

    private boolean isLetterAlreadyBeingUsed(Character letter) {
        return previouslySuggestedLetters.contains(letter);
    }

    private void refreshGuessedLetters(Character letter) {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter) {
                guessedLetters.put(i, letter);
            }
        }
        hangmanInterface.setLettersIndexes(guessedLetters);
    }

    private void prepareGame() {
        // refresh variables
        List<String> words = new Dictionary().getWords();
        int randomNumber = new Random().nextInt(0, words.size());
        hiddenWord = words.get(randomNumber);
        isPlayerLose = false;
        mistakesCounter = 0;
        guessedLetters = new HashMap<>();
        previouslySuggestedLetters = new ArrayList<>();

        // initial variables setup
        hangmanInterface.setHiddenWord(hiddenWord);
        hangmanInterface.setLettersIndexes(guessedLetters);

        hangmanInterface.drawInterface(mistakesCounter);

        playGame();
    }
}
