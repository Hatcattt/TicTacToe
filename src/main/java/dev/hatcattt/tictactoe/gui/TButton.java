package dev.hatcattt.tictactoe.gui;

import javax.swing.*;

/**
 * Represent a button for the game.
 */
public class TButton extends JButton {

    public TButton(String shortName, String textToDisplay) {
        if (shortName != null && textToDisplay != null) {
            String fullName = (shortName.isEmpty() ? "Button" : "Button" + shortName);
            super.setName(fullName);
            super.setText(textToDisplay);
            super.setFocusPainted(false);
        }
    }
    public TButton(String shortName) {
        this(shortName, "");
    }
}
