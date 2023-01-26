package org.petproject;

import java.util.*;

public class HangmanGameImpl implements HangmanGame {

    private final HangmanInterfaceImpl hangmanInterface;
    private final Dictionary dictionary;

    private String hiddenWord;
    private int mistakesCounter;
    private boolean isPlayerLose;
    private Map<Integer, Character> guessedLetters;
    private List<Character> previouslySuggestedLetters;

    public HangmanGameImpl() {
        this.hangmanInterface = new HangmanInterfaceImpl();
        this.dictionary = new Dictionary();
    }

    public HangmanGameImpl(HangmanInterfaceImpl hangmanInterface, Dictionary dictionary) {
        this.hangmanInterface = hangmanInterface;
        this.dictionary = dictionary;
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
            setPlayerLose(true);
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
        List<String> words = dictionary.getWords();
        int randomNumber = new Random().nextInt(0, words.size());
        setHiddenWord(words.get(randomNumber));
        setPlayerLose(false);
        setMistakesCounter(0);
        guessedLetters = new HashMap<>();
        previouslySuggestedLetters = new ArrayList<>();

        // initial variables setup
        hangmanInterface.setHiddenWord(hiddenWord);
        hangmanInterface.setLettersIndexes(guessedLetters);

        hangmanInterface.drawInterface(mistakesCounter);

        playGame();
    }

    public void setGuessedLetters(Map<Integer, Character> guessedLetters) {
        this.guessedLetters = guessedLetters;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public void setMistakesCounter(int mistakesCounter) {
        this.mistakesCounter = mistakesCounter;
    }

    public void setPlayerLose(boolean playerLose) {
        isPlayerLose = playerLose;
    }
}
