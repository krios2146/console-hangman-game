package org.petproject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HangmanGameImplTest {

    @Mock
    private HangmanInterfaceImpl hangmanInterface;

    @Spy
    @InjectMocks
    private HangmanGameImpl hangmanGame;

    @Test
    void initiateGame_ShouldStartTheGame() {
        when(hangmanInterface.askPersonToPlay()).thenReturn("Y");
        doNothing().when(hangmanGame).playGame();

        hangmanGame.initiateGame();

        verify(hangmanInterface).askPersonToPlay();
        verify(hangmanGame).playGame();
    }

    @Test
    void playGame() {
    }

    @Test
    void endGame() {
    }

    @Test
    void exitGame() {
    }
}