package dev.hatcattt.tictactoe.gui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

/**
 * Popup a window when the closing window button of a JFrame is pushed.
 */
public class CheckOnExit extends WindowAdapter {
    private final static Logger LOGGER = Logger.getLogger(CheckOnExit.class.getName());
    private final String message = "Are you sure you want to quit?";
    private final String title = "Wait a second...";
    private final JFrame jFrame;

    /**
     * Apply this Windows adapter on a JFrame, that cannot be null.
     * Otherwise, throws a IllegalArgumentException.
     * @param jFrame the JFrame to apply this adapter.
     * @throws IllegalArgumentException if jFrame is null.
     */
    public CheckOnExit(JFrame jFrame) throws IllegalArgumentException {
        if (jFrame != null) {
            this.jFrame = jFrame;
        } else {
            throw new IllegalArgumentException("The jFrame in parameter cannot be null.");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int clickButton = JOptionPane.showConfirmDialog(jFrame, message, title, JOptionPane.YES_NO_OPTION);
        if (clickButton == JOptionPane.YES_OPTION) {
            jFrame.dispose();
//            LOGGER.log(Level.INFO, "The JFrame have been disposed.");
//        } else {
//            LOGGER.log(Level.INFO, "Someone tried to close the windows.");
        }
    }
}
