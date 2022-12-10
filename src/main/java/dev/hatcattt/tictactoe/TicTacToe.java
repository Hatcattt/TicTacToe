package dev.hatcattt.tictactoe;

import dev.hatcattt.tictactoe.gui.TButton;
import dev.hatcattt.tictactoe.gui.CheckOnExit;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to initialise the main JFrame component.
 */
public class TicTacToe extends JFrame {
    public final static int MAX_BOARD_SIZE = 3;
    private final static String EMPTY_STRING = " ";
    private final static String PLAYER_1 = "X";
    private final static String PLAYER_2 = "O";
    private static String currentPlayer;
    private static final JLabel LABEL_STATUS = new JLabel(BoardStatus.NO_ACTIVE.getText());
    private static final List<JButton> CELLS = new ArrayList<>();
    private static final Font BUTTON_CELL_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 80);

    public TicTacToe() {
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.setSize(450, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.addWindowListener(new CheckOnExit(this));

        LABEL_STATUS.setName("LabelStatus");
        currentPlayer = PLAYER_1;

        // - Main game board -----------------------------------------
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(MAX_BOARD_SIZE, MAX_BOARD_SIZE));

        for (int i = MAX_BOARD_SIZE; i >= 1; i--) {
            CELLS.add(new TButton("A" + i));
            CELLS.add(new TButton("B" + i));
            CELLS.add(new TButton("C" + i));
        }
        CELLS.forEach(C -> {
            C.setText(EMPTY_STRING);
            C.setFont(BUTTON_CELL_FONT);
            C.addActionListener(event -> checkIfTheGameIsDone(C.getText()));
            C.addActionListener(event -> displayStatusByState());
            C.addActionListener(event -> drawAPlayerLetter(C));
        });

        CELLS.forEach(board::add);
        this.add(board);

        // - Footer ---------------------------------------------
        TButton TButtonReset = new TButton("Reset");
        TButtonReset.setText("Reset");
        TButtonReset.addActionListener(event -> resetTheGame());

        JPanel footerBox = new JPanel();
        footerBox.setLayout(new BoxLayout(footerBox, BoxLayout.LINE_AXIS));
        footerBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        footerBox.add(LABEL_STATUS);
        footerBox.add(Box.createVerticalStrut(0));
        footerBox.add(TButtonReset);

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
            case 0 -> LABEL_STATUS.setText(BoardStatus.NO_ACTIVE.getText());
            case 1 -> LABEL_STATUS.setText(BoardStatus.ACTIVE.getText());
            case (MAX_BOARD_SIZE * MAX_BOARD_SIZE) -> LABEL_STATUS.setText(BoardStatus.NO_WINNER.getText());
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
        LABEL_STATUS.setText(BoardStatus.NO_ACTIVE.getText());
        JOptionPane.showMessageDialog(null, "The game have been reset!");
    }

    /**
     * Set the status of the game by a player letter.
     * @param playerLetter the player to check
     */
    private static void setStatusByPlayerLetter(String playerLetter) {
        if (playerLetter.equals(PLAYER_1)) {
            LABEL_STATUS.setText(BoardStatus.X_WIN.getText());
        } else if (playerLetter.equals(PLAYER_2)) {
            LABEL_STATUS.setText(BoardStatus.O_WIN.getText());
        }
    }
}
