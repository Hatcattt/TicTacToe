package dev.hatcattt.tictactoe.main;

import dev.hatcattt.tictactoe.gui.BoxButton;
import dev.hatcattt.tictactoe.gui.PlayerLetters;

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
public class Board extends JPanel {
    private final static Logger LOGGER = Logger.getLogger(Board.class.getName());
    private final static int SIZE = 3;
    // further, maybe a new Board class who can have multiple size like a BoardExtended class
    private final static List<BoxButton> boxButtonsList = new ArrayList<>();
    static {
        for (int i = SIZE; i >= 1; i--) {
            boxButtonsList.add(new BoxButton("A" + i));
            boxButtonsList.add(new BoxButton("B" + i));
            boxButtonsList.add(new BoxButton("C" + i));
        }
    }

    /**
     * Init the board and all the button associated.
     * This board panel have a GridLayout component with the size of 3 * 3.
     */
    public Board() {
        setLayout(new GridLayout(SIZE, SIZE));
        boxButtonsList.forEach(this::add);
        boxButtonsList.forEach(B -> B.addActionListener(event -> setPlayerLetterToAButton(B)));
    }

    /**
     * Set the player letter if the text on the button is empty.
     * @param button the button to change text
     */
    private void setPlayerLetterToAButton(JButton button) {
        if (button.getText().isEmpty()) {
            var playerLetter = PlayerLetters.getLetter();

            button.setText(playerLetter);
            LOGGER.log(Level.INFO, "The letter : '" + playerLetter + "' have been set to this button.");
        }
    }

    /**
     * Get the list of all BoxButton added in this JPanel Board.
     * @return a BoxButton list
     */
    public static List<BoxButton> getBoxButtonsList() {
        return boxButtonsList;
    }

}
