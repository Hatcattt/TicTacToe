package dev.hatcattt.tictactoe.constant;

import javax.swing.*;

import static dev.hatcattt.tictactoe.TicTacToe.BOARD_SIZE;

/**
 * Have methods for verifying if a game is won by a player.
 */
public interface IGameWin {
    public final static int MAX_PLAYER_TOUCH = BOARD_SIZE;

    public static boolean containVertically(JButton[][] array, Object target) {
        int potentialWinCount = 0;

        for (int y = 0; y < MAX_PLAYER_TOUCH; y++) {
            for (int i = 0; i < MAX_PLAYER_TOUCH; i++) {
                if (array[i][y].getText().equals(String.valueOf(target))) potentialWinCount++;
                if (potentialWinCount == MAX_PLAYER_TOUCH) return true;
            }
            potentialWinCount = 0;
        }
        return false;
    }

    public static boolean containHorizontally(JButton[][] array, Object target) {
        int potentialWinCount = 0;

        for (int y = 0; y < MAX_PLAYER_TOUCH; y++) {
            for (int i = 0; i < MAX_PLAYER_TOUCH; i++) {
                if (array[y][i].getText().equals(String.valueOf(target))) potentialWinCount++;
                if (potentialWinCount == MAX_PLAYER_TOUCH) return true;
            }
            potentialWinCount = 0;
        }
        return false;
    }

    public static boolean containLeftDiagonally(JButton[][] array, Object target) {
        int potentialWinCount = 0;

        for (int i = 0; i < MAX_PLAYER_TOUCH; i++) {
            if (array[i][i].getText().equals(String.valueOf(target))) potentialWinCount++;
            if (potentialWinCount == MAX_PLAYER_TOUCH) return true;
        }
        return false;
    }

    public static boolean containRightDiagonally(JButton[][] array, Object target) {
        int potentialWinCount = 0;

        for (int i = MAX_PLAYER_TOUCH - 1, y = 0; i >= 0; i--, y++) {
            if (array[i][y].getText().equals(String.valueOf(target))) potentialWinCount++;
            if (potentialWinCount == MAX_PLAYER_TOUCH) return true;
        }
        return false;
    }
}
