package dev.hatcattt.tictactoe.gui;

import dev.hatcattt.tictactoe.level.GameLevel;

import javax.swing.*;

/**
 * Popup a window before the game start, to choose the difficulty of the game.
 */
public class GameLevelConfiguration {
    public final static GameLevel DEFAULT_LEVEL = GameLevel.NORMAL;
    private final static String ICON_IMAGE_PATH = "src/main/resources/icon/levelIcon.png";
    private static final GameLevel[] GAME_LEVELS = new GameLevel[]{
            GameLevel.NORMAL,
            GameLevel.HARD,
            GameLevel.INSANE
    };
    private final static String MESSAGE = "Select a difficulty...";
    private final static String TITLE = "Game level choice";

    /**
     * Popup a JOptionPane showInputDialog and return the game level  chosen by the user.
     * The NORMAL game level is applied by default.
     * @return the game level choose by the user
     */
    public static GameLevel setAGameLevel() {
        var input = (GameLevel) JOptionPane.showInputDialog(null, MESSAGE,
                TITLE,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(ICON_IMAGE_PATH),
                GAME_LEVELS,
                GAME_LEVELS[0]);

        return (input == null) ? DEFAULT_LEVEL : input;
    }
}
