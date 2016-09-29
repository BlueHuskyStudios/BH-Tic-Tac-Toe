package org.bh.game.ttt.gui;

import java.awt.BorderLayout;
import javax.swing.JComponent;
import org.bh.game.ttt.gui.comps.TicTacToePanel;

/**
 * GUI, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class GUI extends JComponent
{

	public GUI()
	{
		initGUI();
	}

	private TicTacToePanel tttPanel;
	private void initGUI()
	{
		setLayout(new BorderLayout());
		{
			tttPanel = new TicTacToePanel();
			add(tttPanel, BorderLayout.CENTER);
		}
	}
	
}
