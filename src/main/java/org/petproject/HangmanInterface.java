package org.petproject;

public interface HangmanInterface {
    String askPersonToPlay();

    void drawInterface(String word);

    void drawInterface(int mistakes);

    void drawInterface(Character letter);

    String askLetter();

    void endGame();

    void exitGame();
}
