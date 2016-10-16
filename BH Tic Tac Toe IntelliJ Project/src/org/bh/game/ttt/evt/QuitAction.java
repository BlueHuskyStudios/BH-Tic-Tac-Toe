package org.bh.game.ttt.evt;

import javax.swing.*;
import java.awt.event.*;
import java.util.EventObject;

import static org.bh.game.ttt.RuntimeConstantsWrapper.*;

/**
 * QuitAction, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class QuitAction extends AbstractAction {
    public QuitAction() {
        super(RuntimeConstants.getLang().get("menu.app.quit", "Quit"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
