package dev.hatcattt.tictactoe;

import javax.swing.*;

import static dev.hatcattt.tictactoe.TicTacToe.BOARD_SIZE;

/**
 * Have methods for verifying if a game is finish for Arrays of cells.
 */
public interface IGame {
    int MAX_SIZE = BOARD_SIZE;

    static boolean haveAWinner(JButton[][] array, Object target) {
        return containVertically(array, target)
                || containHorizontally(array, target)
                || containLeftDiagonally(array, target)
                || containRightDiagonally(array, target);
    }

    private static boolean containVertically(JButton[][] array, Object target) {
        int countTrue = 0;

        for (int y = 0; y < MAX_SIZE; y++) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (array[i][y].getText().equals(String.valueOf(target))) countTrue++;
                if (countTrue == MAX_SIZE) return true;
            }
            countTrue = 0;
        }
        return false;
    }

    private static boolean containHorizontally(JButton[][] array, Object target) {
        int potentialWinCount = 0;

        for (int y = 0; y < MAX_SIZE; y++) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (array[y][i].getText().equals(String.valueOf(target))) potentialWinCount++;
                if (potentialWinCount == MAX_SIZE) return true;
            }
            potentialWinCount = 0;
        }
        return false;
    }

    private static boolean containLeftDiagonally(JButton[][] array, Object target) {
        int potentialWinCount = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            if (array[i][i].getText().equals(String.valueOf(target))) potentialWinCount++;
            if (potentialWinCount == MAX_SIZE) return true;
        }
        return false;
    }

    private static boolean containRightDiagonally(JButton[][] array, Object target) {
        int potentialWinCount = 0;

        for (int i = MAX_SIZE - 1, y  = 0; i >= 0; i--, y++) {
            if (array[i][y].getText().equals(String.valueOf(target))) potentialWinCount++;
            if (potentialWinCount == MAX_SIZE) return true;
        }
        return false;
    }
}
