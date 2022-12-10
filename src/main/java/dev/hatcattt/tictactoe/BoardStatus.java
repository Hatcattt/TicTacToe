package dev.hatcattt.tictactoe;

/**
 * Represent the status of the game in real time.
 */
public enum BoardStatus {

    ACTIVE("Game in progress"),
    NO_ACTIVE("Game is not started"),

    X_WIN("X wins"),
    O_WIN("O wins"),
    NO_WINNER("Draw");

    private final String textStatus;

    BoardStatus(String textLabel) {
        this.textStatus = textLabel;
    }

    public String getText() {
        return textStatus;
    }
}
