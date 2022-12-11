package dev.hatcattt.tictactoe;

import dev.hatcattt.tictactoe.gui.TButton;
import dev.hatcattt.tictactoe.gui.CheckOnExit;

import javax.swing.*;
import java.awt.*;

/**
 * Class used to initialise the main JFrame component.
 */
public class TicTacToe extends JFrame implements GameConstants {
    static String currentPlayer;
    static final JLabel LABEL_STATUS = new JLabel(BoardStatus.NO_ACTIVE.getText());
    static final TButton[][] CELLS = new TButton[BOARD_SIZE][BOARD_SIZE];
    final static JPanel BOARD = new JPanel();

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
        BOARD.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        initAllButtons();

        this.add(BOARD);

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
     * Init all the buttons presents in the cells.
     */
    private static void initAllButtons() {
        int nameID = 1;

        for (int i = 0, start = BUTTON_ASCII_CODE_START; i < CELLS.length; i++, start++) {
            for (int y = 0; y < CELLS[i].length; y++) {
                final int finalI = i;
                final int finalY = y;

                CELLS[i][y] = new TButton(Character.toString((char) start) + nameID);
                CELLS[i][y].setText(EMPTY_STRING);
                CELLS[i][y].setFont(BUTTON_CELL_FONT);
                CELLS[i][y].addActionListener(event -> checkIfTheGameIsDone(CELLS[finalI][finalY]));
                CELLS[i][y].addActionListener(event -> displayStatusByState());
                CELLS[i][y].addActionListener(event -> drawAPlayerLetter(CELLS[finalI][finalY]));
                BOARD.add(CELLS[i][y]);

                nameID++;
            }
            nameID = 1;
        }
    }

    /**
     * Check if the current player have a specific position to win the game.
     * If it does, all button in the cell are disabled.
     */
    private static void checkIfTheGameIsDone(TButton player) {
        if (IGame.haveAWinner(CELLS, player.getText())) {
            setStatusByPlayerLetter(player.getText());

            for (var cells : CELLS) {
                for (var cell : cells) {
                    cell.setEnabled(false);
                }
            }
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
            case (BOARD_SIZE * BOARD_SIZE) -> LABEL_STATUS.setText(BoardStatus.NO_WINNER.getText());
        }
    }

    /**
     * Get the number of no empty cell text.
     * @return the number of no empty cell.
     */
    private static int getNumberOfCellPlayed() {
        int count = 0;
        for (var cells : CELLS) {
            for (var cell : cells) {
                if (!cell.getText().equals(EMPTY_STRING)) count++;
            }
        }
        return count;
    }

    /**
     * Reset the game, so the players can make another one.
     */
    private static void resetTheGame() {
        for (var cells : CELLS) {
            for (var cell : cells) {
                cell.setText(EMPTY_STRING);
                cell.setEnabled(true);
            }
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
