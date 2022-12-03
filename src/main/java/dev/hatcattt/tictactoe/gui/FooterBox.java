package dev.hatcattt.tictactoe.gui;

import javax.swing.*;

public class FooterBox extends JPanel {
    LabelStatus labelStatus = new LabelStatus(Status.NO_ACTIVE);
    public ButtonReset resetButton = new ButtonReset();

    public FooterBox() {
        add(labelStatus);
        add(resetButton);

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }
}
