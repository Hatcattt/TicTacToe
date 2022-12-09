package dev.hatcattt.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static dev.hatcattt.tictactoe.TicTacToe.MAX_BOARD_SIZE;

/**
 * Class used to initialise the main JFrame component.
 */
public class TicTacToe extends JFrame {
    public final static int MAX_BOARD_SIZE = 3;
    private final static String EMPTY_STRING = " ";
    private final static String PLAYER_1 = "X";
    private final static String PLAYER_2 = "O";
    private static String currentPlayer;
    private final static JLabel labelStatus = new JLabel(BoardStatus.NO_ACTIVE.getText());
    private static final List<JButton> CELLS = new ArrayList<>();

    public TicTacToe() {
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(450, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        labelStatus.setName("LabelStatus");
        currentPlayer = PLAYER_1;

        // - Main game board -----------------------------------------
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(MAX_BOARD_SIZE, MAX_BOARD_SIZE));

        for (int i = MAX_BOARD_SIZE; i >= 1; i--) {
            CELLS.add(new BoxButton("A" + i));
            CELLS.add(new BoxButton("B" + i));
            CELLS.add(new BoxButton("C" + i));
        }
        CELLS.forEach(C -> {
            C.setText(EMPTY_STRING);
            C.setFocusPainted(false);
            C.addActionListener(event -> checkIfTheGameIsDone(C.getText()));
            C.addActionListener(event -> displayStatusByState());
            C.addActionListener(event -> drawAPlayerLetter(C));
        });

        CELLS.forEach(board::add);
        this.add(board);

        // - Footer ---------------------------------------------
        JButton buttonReset = new JButton("Reset");
        buttonReset.setName("ButtonReset");
        buttonReset.addActionListener(event -> resetTheGame());

        JPanel footerBox = new JPanel();
        footerBox.setLayout(new BoxLayout(footerBox, BoxLayout.LINE_AXIS));
        footerBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        footerBox.add(labelStatus);
        footerBox.add(Box.createVerticalStrut(0));
        footerBox.add(buttonReset);

        this.add(footerBox, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /**
     * Check if the player have a specific position to win the game.
     * If it does, all button in the cell are disabled.
     * @param currentPlayer the player to verifying his position
     */
    private static void checkIfTheGameIsDone(String currentPlayer) {
        if (IGameWin.isAVerticalWin(CELLS, currentPlayer)
                || IGameWin.isAHorizontalWin(CELLS, currentPlayer)
                || IGameWin.isADiagonalWin(CELLS, currentPlayer)) {

            setStatusByPlayerLetter(currentPlayer);
            CELLS.forEach(C -> C.setEnabled(false));
        }
    }

    /**
     * Swap players letters, so the current player will be the second.
     */
    private static void swapPlayers() {
        if (currentPlayer.equals(PLAYER_2)) {
            currentPlayer = PLAYER_1;
        } else if (currentPlayer.equals(PLAYER_1)) {
            currentPlayer = PLAYER_2;
        }
    }

    /**
     * Set a player letter for this button text.
     * @param jButton the button to set the text
     */
    private static void drawAPlayerLetter(JButton jButton) {
        if (jButton.getText().equals(EMPTY_STRING)) {
            jButton.setText(currentPlayer);
            swapPlayers();
        }
    }

    /**
     * Display some status by the number of no empty inside the cells.
     */
    private static void displayStatusByState() {
        switch (getNumberOfCellPlayed()) {
            case 0 -> labelStatus.setText(BoardStatus.NO_ACTIVE.getText());
            case 1 -> labelStatus.setText(BoardStatus.ACTIVE.getText());
            case (MAX_BOARD_SIZE * MAX_BOARD_SIZE) -> labelStatus.setText(BoardStatus.NO_WINNER.getText());
        }
    }

    /**
     * Get the number of no empty cell text.
     * @return the number of no empty cell.
     */
    private static int getNumberOfCellPlayed() {
        return (int) CELLS.stream()
                .filter(B -> !B.getText().equals(EMPTY_STRING))
                .count();
    }

    /**
     * Reset the game, so the players can make another one.
     */
    private static void resetTheGame() {
        for (var cell : CELLS) {
            cell.setText(EMPTY_STRING);
            cell.setEnabled(true);
        }
        currentPlayer = PLAYER_1;
        labelStatus.setText(BoardStatus.NO_ACTIVE.getText());
        JOptionPane.showMessageDialog(null, "The game have been reset!");
    }

    /**
     * Set the status of the game by a player letter.
     * @param playerLetter the player to check
     */
    private static void setStatusByPlayerLetter(String playerLetter) {
        if (playerLetter.equals(PLAYER_1)) {
            labelStatus.setText(BoardStatus.X_WIN.getText());
        } else if (playerLetter.equals(PLAYER_2)) {
            labelStatus.setText(BoardStatus.O_WIN.getText());
        }
    }
}

/**
 * Represent the status of the game in real time.
 */
enum BoardStatus {

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

/**
 * Represent a button with a name.
 */
class BoxButton extends JButton {
    public BoxButton(String shortName) {
        if (shortName != null) {
            String fullName = (shortName.isEmpty() ? "Button" : "Button" + shortName);
            super.setName(fullName);
            setFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));
        }
    }
}

/**
 * Have methods for verifying if a game is finish.
 */
interface IGameWin {
    static boolean isAVerticalWin(List<JButton> jButtonList, String playerLetter) {
        for (int i = 0, y = MAX_BOARD_SIZE; i < y; i++) {
            if (jButtonList.get(i).getText().equals(playerLetter) &&
                    jButtonList.get(i + y).getText().equals(playerLetter) &&
                    jButtonList.get(i + y + y).getText().equals(playerLetter)) {
                return true;
            }
        }
        return false;
    }

    static boolean isAHorizontalWin(List<JButton> jButtonList, String playerLetter) {
        for (int i = 0, y = MAX_BOARD_SIZE * MAX_BOARD_SIZE; i < y; i+=MAX_BOARD_SIZE) {
            if (jButtonList.get(i).getText().equals(playerLetter) &&
                    jButtonList.get(i + 1).getText().equals(playerLetter) &&
                    jButtonList.get(i + 2).getText().equals(playerLetter)) {
                return true;
            }
        }
        return false;
    }

    static boolean isADiagonalWin(List<JButton> jButtonList, String playerLetter) {
        if (jButtonList.get(MAX_BOARD_SIZE + 1).getText().equals(playerLetter)) {
            for (int i = 0, y = jButtonList.size() - 1, loop = 2; loop > 0; loop--, i+=6, y-=6) {
                if (jButtonList.get(i).getText().equals(playerLetter) &&
                        jButtonList.get(y).getText().equals(playerLetter)) {
                    return true;
                }
            }
        }
        return false;
    }
}
