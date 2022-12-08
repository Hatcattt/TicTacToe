package dev.hatcattt.tictactoe.gui;

import dev.hatcattt.tictactoe.main.BoardStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Logger;

/**
 * Reset all the JButton present in a list.
 */
public class ButtonReset extends JButton {
    private final static Logger LOGGER = Logger.getLogger(ButtonReset.class.getName());
    private List<JButton> jButtonList;
    private final String name = "Reset";
    private LabelStatus labelStatus;

    public ButtonReset(List<JButton> jButtonList, LabelStatus labelStatus) {
        if (jButtonList != null) {
            this.jButtonList = jButtonList;
        }
        super.setName(name);
        super.setText(name);
        this.addActionListener(event -> reset());
        this.labelStatus = labelStatus;
    }

    private void reset() {
        for (var jb : jButtonList) {
            jb.setText("");
            jb.setEnabled(true);
        }
        labelStatus.setStatus(BoardStatus.NO_ACTIVE);
        JOptionPane.showMessageDialog(null, "The game have been reset!");
    }
}
