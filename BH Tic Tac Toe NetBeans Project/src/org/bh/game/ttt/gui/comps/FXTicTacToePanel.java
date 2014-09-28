package org.bh.game.ttt.gui.comps;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * TicTacToePanel, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class FXTicTacToePanel extends BorderPane
{

	public FXTicTacToePanel()
	{
		
		initGUI();
	}

	private void initGUI()
	{
		Label placeholder = new Label("Tic Tac Toe");
		placeholder.setAlignment(Pos.CENTER);
		setCenter(placeholder);
	}
	
}
