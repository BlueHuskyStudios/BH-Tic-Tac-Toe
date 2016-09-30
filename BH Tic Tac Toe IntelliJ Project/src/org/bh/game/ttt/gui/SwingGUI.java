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
public class SwingGUI extends JComponent
{

	public SwingGUI(TicTacToeGrid model)
	{
		initGUI(model);
	}

	private TicTacToeGridView tttPanel;
	private void initGUI(TicTacToeGrid model)
	{
		setLayout(new BorderLayout());
		{
			tttPanel = new TicTacToeGridView(model);
			add(tttPanel, BorderLayout.CENTER);
		}
	}
	
}
