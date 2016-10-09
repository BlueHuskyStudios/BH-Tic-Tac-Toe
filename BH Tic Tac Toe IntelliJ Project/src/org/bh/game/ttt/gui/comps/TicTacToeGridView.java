package org.bh.game.ttt.gui.comps;

import org.bh.game.ttt.game.*;
import org.bh.game.ttt.game.TicTacToeGrid.*;
import org.bh.tools.struct.coord.*;

import javax.swing.*;
import java.awt.*;

import static sun.awt.shell.ShellFolder.invoke;

/**
 * TicTacToeGridView, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class TicTacToeGridView extends JComponent {
    private static String _defaultStatusMessage = "Game not started";
    private TicTacToeGrid _model;
    private final JLabel _statusLabel = invoke(() -> {
        JLabel ret = new JLabel(_defaultStatusMessage);
        ret.setHorizontalAlignment(JLabel.CENTER);
        return ret;
    });

    public TicTacToeGridView(TicTacToeGrid model) {
        _model = model;
        reloadGUI();
    }

    private void reloadGUI() {
        removeAll();

        if (_model == null || _statusIsMoreImportant) {
            setLayout(new BorderLayout());
            _statusLabel.setText(_statusMessage == null ? _defaultStatusMessage : _statusMessage);
            add(_statusLabel, BorderLayout.CENTER);
        } else {
            Size<Integer> modelSize = _model.size();
            setLayout(new GridLayout(modelSize.getWidth(), modelSize.getHeight()));
            for (TicTacToeSquare[] squareRow : _model.squareRows()) {
                for (TicTacToeSquare square : squareRow) {
                    add(new TicTacToeSquareView(square));
                }
            }
        }
    }

    private boolean _statusIsMoreImportant = false;
    private String _statusMessage = null;

    public void showStatus(String newStatus) {
        _statusIsMoreImportant = null != newStatus;
        _statusMessage = newStatus;
        reloadGUI();
    }
}
