package dev.hatcattt.tictactoe.gui;

/**
 * Represent the letter that the players play on the main board.
 */
public class PlayerLetters {
    private static final String[] LETTERS = new String[] {"X", "O"};
    private final String currentLetter = LETTERS[index];
    private static int index = 1;

    /**
     * Change the index dynamically. If index = 1 then index = 0 and vice versa.
     */
    private static void changeIndexLetter() {
        index = index == 1 ? 0 : 1;
    }

    /**
     * Get a letter that alternates between the X and the O statically.
     * @return a letter (X than 0 after the second call)
     */
    public static String getLetter() {
        changeIndexLetter();
        return LETTERS[index];
    }

    /**
     * Get the current letter of the player.
     * @return the current letter of the player
     */
    public String getCurrentLetter() {
        return currentLetter;
    }
}
