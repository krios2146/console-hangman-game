package org.petproject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HangmanGameImplTest {

    @Mock
    private HangmanInterfaceImpl hangmanInterface;
    @Mock
    private Dictionary dictionary;

    @Spy
    @InjectMocks
    private HangmanGameImpl hangmanGame;

    @Test
    void initiateGame_ShouldStartTheGame() {
        when(hangmanInterface.askPersonToPlay()).thenReturn("Y");
        when(dictionary.getWords()).thenReturn(List.of("secret"));
        doNothing().when(hangmanGame).playGame();

        hangmanGame.initiateGame();

        verify(hangmanInterface).askPersonToPlay();
        verify(hangmanGame).playGame();
    }

    @Test
    void initiateGame_ShouldExitTheGame() {
        when(hangmanInterface.askPersonToPlay()).thenReturn("N");

        hangmanGame.initiateGame();

        verify(hangmanInterface).exitGame();
        verify(hangmanGame).exitGame();
    }

    @Test
    void initiateGame_ShouldCallInitialInterfaceSetupMethods() {
        when(hangmanInterface.askPersonToPlay()).thenReturn("Y");
        when(dictionary.getWords()).thenReturn(List.of("secret"));
        doNothing().when(hangmanGame).playGame();

        hangmanGame.initiateGame();

        verify(hangmanInterface).setLettersIndexes(anyMap());
        verify(hangmanInterface).setHiddenWord(anyString());
        verify(hangmanInterface).drawInterface(0);
    }

    @Test
    void playGame_ShouldLoseTheGame() {
        when(hangmanInterface.askPersonToPlay()).thenReturn("Y", "N");
        when(hangmanInterface.askLetter()).thenReturn("a", "b", "c", "d", "f", "g", "h", "j", "k");
        when(dictionary.getWords()).thenReturn(List.of("secret"));

        hangmanGame.initiateGame();

        verify(hangmanInterface, atLeast(6)).askLetter();
        verify(hangmanInterface, atLeast(6)).drawInterface(anyInt());
        verify(hangmanInterface).endGame(true);
    }

    @Test
    void playGame_ShouldWarmAboutAlreadyUsedLetterAndLoseTheGame() {
        when(hangmanInterface.askPersonToPlay()).thenReturn("Y", "N");
        when(hangmanInterface.askLetter()).thenReturn("a", "a", "c", "d", "f", "g", "h", "j", "k");
        when(dictionary.getWords()).thenReturn(List.of("secret"));

        hangmanGame.initiateGame();

        verify(hangmanInterface, atLeastOnce()).alreadySuggestedLetterWarning();
        verify(hangmanInterface, atLeast(6)).askLetter();
        verify(hangmanInterface, atLeast(6)).drawInterface(anyInt());
        verify(hangmanInterface).endGame(true);
    }

    @Test
    void playGame_ShouldWinTheGame() {
        when(hangmanInterface.askPersonToPlay()).thenReturn("Y", "N");
        when(hangmanInterface.askLetter()).thenReturn("s", "e", "c", "r", "t");
        when(dictionary.getWords()).thenReturn(List.of("secret"));

        hangmanGame.initiateGame();

        verify(hangmanInterface, times(5)).askLetter();
        verify(hangmanInterface, times(6)).drawInterface(0);
        verify(hangmanInterface).endGame(false);
    }

    @Test
    void endGame_ShouldInitiateTheGameAgain() {
        doNothing().when(hangmanGame).initiateGame();

        hangmanGame.endGame(anyBoolean());

        verify(hangmanInterface).endGame(anyBoolean());
        verify(hangmanGame).initiateGame();
    }

    @Test
    void exitGame_ShouldExitTheGame() {
        hangmanGame.exitGame();

        verify(hangmanInterface).exitGame();
    }
}