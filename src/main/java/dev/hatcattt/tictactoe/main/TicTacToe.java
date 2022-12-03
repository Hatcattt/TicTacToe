package dev.hatcattt.tictactoe.main;

import dev.hatcattt.tictactoe.gui.CheckOnExit;
import dev.hatcattt.tictactoe.gui.FooterBox;

import javax.swing.*;
import java.awt.*;

/**
 * Class used to initialise the main JFrame component.
 */
public class TicTacToe extends JFrame {
//    private final static Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());

    public TicTacToe() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        addWindowListener(new CheckOnExit(this));
        add(new Board());
        add(new FooterBox(), BorderLayout.SOUTH);
        setVisible(true);
    }
}
