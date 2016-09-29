package org.bh.game.ttt.gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import org.bh.game.ttt.gui.comps.FXTicTacToePanel;

/**
 * GUI, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class FXGUI extends Scene
{

	public FXGUI()
	{
		super(null);
	}
	
	public FXGUI(Parent root)
	{
		super(root);
		initGUI();
	}

	private FXTicTacToePanel tttPanel;
	private void initGUI()
	{
		tttPanel = new FXTicTacToePanel();
		setRoot(tttPanel);
	}
	
}
