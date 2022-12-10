package dev.hatcattt.tictactoe;

import javax.swing.*;
import java.util.List;

import static dev.hatcattt.tictactoe.TicTacToe.MAX_BOARD_SIZE;

/**
 * Have methods for verifying if a game is finish for Array of cells.
 */
public interface IGameWin {
    int MAX_SIZE = MAX_BOARD_SIZE;

    static boolean isAWinner(JButton[][] array, Object target) {
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



    static boolean isAVerticalWin(List<JButton> jButtonList, String playerLetter) {
        for (int i = 0, y = MAX_BOARD_SIZE; i < y; i++) {
            if (jButtonList.get(i).getText().equals(playerLetter) &&
                    jButtonList.get(i + y).getText().equals(playerLetter) &&
                    jButtonList.get(i + y + y).getText().equals(playerLetter)) {
                return true;
            }
        }
        return false;
    }

    static boolean isAHorizontalWin(List<JButton> jButtonList, String playerLetter) {
        for (int i = 0, y = MAX_BOARD_SIZE * MAX_BOARD_SIZE; i < y; i+=MAX_BOARD_SIZE) {
            if (jButtonList.get(i).getText().equals(playerLetter) &&
                    jButtonList.get(i + 1).getText().equals(playerLetter) &&
                    jButtonList.get(i + 2).getText().equals(playerLetter)) {
                return true;
            }
        }
        return false;
    }

    static boolean isADiagonalWin(List<JButton> jButtonList, String playerLetter) {
        if (jButtonList.get(MAX_BOARD_SIZE + 1).getText().equals(playerLetter)) {
            for (int i = 0, y = jButtonList.size() - 1, loop = 2; loop > 0; loop--, i+=6, y-=6) {
                if (jButtonList.get(i).getText().equals(playerLetter) &&
                        jButtonList.get(y).getText().equals(playerLetter)) {
                    return true;
                }
            }
        }
        return false;
    }
}
