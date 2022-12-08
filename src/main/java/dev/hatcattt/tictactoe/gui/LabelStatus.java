package dev.hatcattt.tictactoe.gui;

import dev.hatcattt.tictactoe.main.BoardStatus;

import java.awt.*;

/**
 * This label is used to display the status of the game.
 */
public class LabelStatus extends Label {
    private BoardStatus status;

    public LabelStatus() {
        setStatus(BoardStatus.NO_ACTIVE);
    }

    public void setStatus(BoardStatus status) {
        this.status = status;
        super.setText(this.status.getTextStatus());
    }

    public void setStatusByPlayerLetter(String playerLetter) {
        if (playerLetter.equals("X")) {
            setStatus(BoardStatus.X_WIN);
        } else if (playerLetter.equals("O")) {
            setStatus(BoardStatus.O_WIN);
        }
    }
}
