package dev.hatcattt.tictactoe.gui;

import dev.hatcattt.tictactoe.main.Board;

import javax.swing.*;

public class FooterBox extends JPanel  {
    public LabelStatus labelStatus = new LabelStatus();
    public ButtonReset buttonReset = new ButtonReset(Board.getBoxButtonsList(), labelStatus);

    public FooterBox() {

        add(labelStatus);
        add(buttonReset);

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

    }

    public LabelStatus getLabelStatus() {
        return labelStatus;
    }
}
