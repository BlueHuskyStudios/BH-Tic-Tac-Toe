package org.bh.game.ttt.gui;

import org.bh.game.ttt.game.*;
import org.bh.game.ttt.gui.comps.*;

import javax.swing.*;
import java.awt.*;

/**
 * SwingGUI, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class SwingGUI extends JComponent {

    private TicTacToeGridView tttPanel;
    private TicTacToeGrid     _model;

    public SwingGUI(TicTacToeGrid model) {
        _model = model;
        reloadGUI();
    }

    private void reloadGUI() {
        setLayout(new BorderLayout());
        {
            tttPanel = new TicTacToeGridView(_model);
            add(tttPanel, BorderLayout.CENTER);
        }
    }

    public void showStatus(String newStatus) {
        tttPanel.showStatus(newStatus);
    }

    public void setGrid(TicTacToeGrid grid) {
        _model = grid;
        reloadGUI();
    }
}
