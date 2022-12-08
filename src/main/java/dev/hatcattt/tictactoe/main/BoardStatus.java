package dev.hatcattt.tictactoe.main;

public enum BoardStatus {

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
    BoardStatus(String textLabel) {
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
