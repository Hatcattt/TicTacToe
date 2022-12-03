package dev.hatcattt.tictactoe.gui;

import java.awt.*;

/**
 * Represent the status of the game.
 */
enum Status {

    ACTIVE("The game is active"),
    NO_ACTIVE("The game is not lunch yet."),

    X_WIN("X win the game!"),
    O_WIN("O win the game!"),
    NO_WINNER("There are no winner for this game!");

    private final String textStatus;

    /**
     * Construct this enum.
     * @param textLabel the text of the status
     */
    Status(String textLabel) {
        this.textStatus = textLabel;
    }

    /**
     * Get the text of the status
     * @return The text of the status
     */
    public String getTextStatus() {
        return textStatus;
    }
}

/**
 * This label is used to display the status of the game.
 */
public class LabelStatus extends Label {
    private Status status;

    /**
     * Construct the label.
     * @param status the status (enum) to put in
     */
    public LabelStatus(Status status) {
        this.status = status;
        super.setText(status.getTextStatus());
    }
}
