package dev.hatcattt.tictactoe.main;

import javax.swing.*;
import java.util.List;

public interface IGameWin {
    default boolean isAVerticalWin(List<JButton> jButtonList, String playerLetter) {
        return (jButtonList.get(0).getText().equals(playerLetter) &&
                jButtonList.get(3).getText().equals(playerLetter) &&
                jButtonList.get(6).getText().equals(playerLetter))
                ||
                (jButtonList.get(1).getText().equals(playerLetter) &&
                 jButtonList.get(4).getText().equals(playerLetter) &&
                 jButtonList.get(7).getText().equals(playerLetter))
                ||
                (jButtonList.get(2).getText().equals(playerLetter) &&
                 jButtonList.get(5).getText().equals(playerLetter) &&
                 jButtonList.get(8).getText().equals(playerLetter));
    }

    default boolean isAHorizontalWin(List<JButton> jButtonList, String playerLetter) {
        return (jButtonList.get(0).getText().equals(playerLetter) &&
                jButtonList.get(1).getText().equals(playerLetter) &&
                jButtonList.get(2).getText().equals(playerLetter))
                ||
                (jButtonList.get(3).getText().equals(playerLetter) &&
                 jButtonList.get(4).getText().equals(playerLetter) &&
                 jButtonList.get(5).getText().equals(playerLetter))
                ||
                (jButtonList.get(6).getText().equals(playerLetter) &&
                 jButtonList.get(7).getText().equals(playerLetter) &&
                 jButtonList.get(8).getText().equals(playerLetter));
    }

    default boolean isADiagonalWin(List<JButton> jButtonList, String playerLetter) {
        return (jButtonList.get(0).getText().equals(playerLetter) &&
                jButtonList.get(4).getText().equals(playerLetter) &&
                jButtonList.get(8).getText().equals(playerLetter))
                ||
                (jButtonList.get(2).getText().equals(playerLetter) &&
                 jButtonList.get(4).getText().equals(playerLetter) &&
                 jButtonList.get(6).getText().equals(playerLetter));
    }
}
