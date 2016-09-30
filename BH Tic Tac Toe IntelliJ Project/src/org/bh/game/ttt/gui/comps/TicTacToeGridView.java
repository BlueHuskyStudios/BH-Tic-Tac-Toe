package org.bh.game.ttt.gui.comps;

import org.bh.game.ttt.game.*;
import org.bh.game.ttt.game.TicTacToeGrid.*;
import org.bh.tools.struct.coord.*;

import javax.swing.*;
import java.awt.*;

/**
 * TicTacToeGridView, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class TicTacToeGridView extends JComponent {
    private TicTacToeGrid _model;

    public TicTacToeGridView(TicTacToeGrid model) {
        _model = model;
        initGUI();
    }

    private void initGUI() {
        Size<Integer> modelSize = _model.size();
        setLayout(new GridLayout(modelSize.getWidth(), modelSize.getHeight()));
        for (TicTacToeSquare[] squareRow : _model.squareRows()) {
            for (TicTacToeSquare square : squareRow) {
                add(new TicTacToeSquareView(square));
            }
        }
    }
}
