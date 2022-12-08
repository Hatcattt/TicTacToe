package dev.hatcattt.tictactoe.main;

import dev.hatcattt.tictactoe.gui.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represent the main board game panel.
 * This class extend the JPanel component and have a GridLayout of 3*3 size.
 */
public class Board extends JPanel implements IGameWin {
    private final static Logger LOGGER = Logger.getLogger(Board.class.getName());
    private final static int SIZE = 3;
    // further, maybe a new Board class who can have multiple size like a BoardExtended class
    private final static List<JButton> boxButtonsList = new ArrayList<>();
    private LabelStatus labelStatus;
    private PlayerLetters playerLetter = new PlayerLetters();
    private String currentLetter = playerLetter.getCurrentLetter();

    /**
     * Init the board and all the button associated.
     * This board panel have a GridLayout component with the size of 3 * 3.
     */
    public Board(LabelStatus labelStatus) {
        for (int i = SIZE; i >= 1; i--) {
            boxButtonsList.add(new BoxButton("A" + i));
            boxButtonsList.add(new BoxButton("B" + i));
            boxButtonsList.add(new BoxButton("C" + i));
        }

        this.labelStatus = labelStatus;
        super.setLayout(new GridLayout(SIZE, SIZE));
        boxButtonsList.forEach(this::add);
        boxButtonsList.forEach(B -> B.addActionListener(event -> changeStatus()));
        boxButtonsList.forEach(B -> B.addActionListener(event -> setTextToAButton(B)));
    }

    /**
     * Set the player letter if the text on the button is empty.
     * @param button the button to change text
     */
    private void setTextToAButton(JButton button) {
        if (button.getText().isEmpty()) {
            String playerLetter = PlayerLetters.getLetter();
            this.currentLetter = playerLetter;

            button.setText(currentLetter);
            LOGGER.log(Level.INFO, "The letter : '" + playerLetter + "' have been set to this button.");
        }
    }

    /**
     * Get the list of all BoxButton added in this JPanel Board.
     * @return a BoxButton list
     */
    public static List<JButton> getBoxButtonsList() {
        return boxButtonsList;
    }

    private void changeStatus() {
        int numberOfNonEmptyButton = (int) boxButtonsList.stream().filter(B -> !B.getText().isEmpty()).count();

        if (numberOfNonEmptyButton >= 1) {
            labelStatus.setStatus(BoardStatus.ACTIVE);
        }
        if (numberOfNonEmptyButton == boxButtonsList.size()) {
            labelStatus.setStatus(BoardStatus.NO_WINNER);
        }
        checkIfAPlayerWin();
    }

    private void checkIfAPlayerWin() {
        if (isAHorizontalWin(boxButtonsList, currentLetter)
                || isAVerticalWin(boxButtonsList, currentLetter)
                || isADiagonalWin(boxButtonsList, currentLetter)) {

            labelStatus.setStatusByPlayerLetter(currentLetter);
            boxButtonsList.forEach(B -> B.setEnabled(false));
        }
    }
}
