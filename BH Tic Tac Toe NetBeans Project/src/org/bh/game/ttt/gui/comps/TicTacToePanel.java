package org.bh.game.ttt.gui.comps;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * TicTacToePanel, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class TicTacToePanel extends JComponent
{

	public TicTacToePanel()
	{
		initGUI();
	}

	private void initGUI()
	{
		setLayout(new BorderLayout());
		add(new JLabel("Tic Tac Toe!"), BorderLayout.CENTER);
	}
	
}
