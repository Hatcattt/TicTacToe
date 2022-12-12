package dev.hatcattt.tictactoe.level;

/**
 * Represent a difficulty level for the game.
 * The size of a level represent the future size of the game.
 */
public enum GameLevel {
    NORMAL(3),
    HARD(4),
    INSANE(5);

    private final int sizeOfLevel;

    /**
     * Init this enum with a size of the level in parameter.
     */
    private GameLevel(int sizeOfLevel) {
        this.sizeOfLevel = sizeOfLevel;
    }

    /**
     * Get the size of the level.
     * @return the size of the level
     */
    public int getSizeOfLevel() {
        return this.sizeOfLevel;
    }
}
