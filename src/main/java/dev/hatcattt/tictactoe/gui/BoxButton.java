package dev.hatcattt.tictactoe.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Class used as a button and extend the JButton class.
 */
public class BoxButton extends JButton {
    private String fullName;
    private String shortName;

    /**
     * Init a BoxButton with no argument (base JButton) with the name "Button".
     */
    public BoxButton() {
        this.fullName = "Button";
        setName(fullName);
    }

    /**
     * Init a BoxButton with a short name.
     * The full name of the button after will be "Button" + short name.
     *
     * @param shortName the short name of the button.
     */
    public BoxButton(String shortName) {
        if (shortName != null) {
            this.shortName = shortName.trim();

            fullName = (this.shortName.isEmpty() ? "Button" : "Button" + this.shortName);
            setBoxFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));
        }
    }

    /**
     * Set the font of this button.
     * @param font the font to apply
     */
    public void setBoxFont(Font font) {
        if (font != null) {
            setFont(font);
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }
}
