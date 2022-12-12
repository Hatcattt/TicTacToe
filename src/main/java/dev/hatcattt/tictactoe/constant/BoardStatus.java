package dev.hatcattt.tictactoe.constant;

/**
 * Represent the status of the game in real time.
 */
public enum BoardStatus {

    ACTIVE("Game in progress..."),
    NO_ACTIVE("Game is not started."),

    X_WIN("X wins!"),
    O_WIN("O wins!"),
    NO_WINNER("No winner this time!");

    private final String textStatus;

    /**
     * Init this enum with a message to put on the textLabel.
     * @param textLabel the message to put
     */
    private BoardStatus(String textLabel) {
        this.textStatus = textLabel;
    }

    public String getText() {
        return textStatus;
    }
}
