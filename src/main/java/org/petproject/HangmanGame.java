package org.petproject;

public interface HangmanGame {
    void initiateGame();

    void playGame();

    void exitGame();

    void endGame(boolean isPlayerLose);
}
