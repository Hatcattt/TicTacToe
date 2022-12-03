package dev.hatcattt.tictactoe.gui;

import dev.hatcattt.tictactoe.main.Board;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Reset the Board box buttons list to empty string.
 */
public class ButtonReset extends JButton {
    private final static Logger LOGGER = Logger.getLogger(ButtonReset.class.getName());
    private final String name = "Reset";

    public ButtonReset() {
        super.setName(name);
        super.setText(name);
        this.addActionListener(e -> resetButtonText());
    }

    private void resetButtonText() {
        for (var B : Board.getBoxButtonsList()) {
            B.setText("");
        }
//        LOGGER.log(Level.INFO, "The board have been reset.");
    }
}
