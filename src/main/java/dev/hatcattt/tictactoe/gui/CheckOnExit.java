package dev.hatcattt.tictactoe.gui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Popup a window when the closing window button of a JFrame is pushed.
 */
public class CheckOnExit extends WindowAdapter {
    private final static String MESSAGE = "Are you sure you want to quit?";
    private final static String TITLE = "Wait a second...";
    private final JFrame jFrame;

    /**
     * Apply this Windows adapter on a JFrame, that cannot be null.
     * Otherwise, throws a IllegalArgumentException.
     * @param jFrame the JFrame to apply this adapter.
     * @throws IllegalArgumentException if jFrame is null.
     */
    public CheckOnExit(final JFrame jFrame) throws IllegalArgumentException {
        if (jFrame != null) {
            this.jFrame = jFrame;
        } else {
            throw new IllegalArgumentException("jFrame cannot be null.");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int clickButton = JOptionPane.showConfirmDialog(jFrame, MESSAGE, TITLE, JOptionPane.YES_NO_OPTION);
        if (clickButton == JOptionPane.YES_OPTION) {
            jFrame.dispose();
        }
    }
}