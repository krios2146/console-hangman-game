package org.petproject;

public interface HangmanInterface {
    String askPersonToPlay();

    void drawInterface(int mistakes);

    String askLetter();

    void endGame(boolean isPlayerLost);

    void exitGame();
}
