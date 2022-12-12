package dev.hatcattt.tictactoe.constant;

import dev.hatcattt.tictactoe.gui.GameLevelConfiguration;
import dev.hatcattt.tictactoe.level.GameLevel;

import java.awt.*;

/**
 * Some constants for the game.
 */
public interface IGameConstants {
    public final static int WINDOWS_SIZE = 500;
    public final static int BUTTON_ASCII_CODE_START = 65;
    public final static GameLevel GAME_LEVEL = GameLevelConfiguration.setAGameLevel();
    public final static String GAME_NAME = "Tic Tac Toe";
    public final static String PLAYER_1 = "X";
    public final static String PLAYER_2 = "O";
    public final static String EMPTY_STRING = " ";
    public final static Font BUTTON_CELL_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 80);
}
