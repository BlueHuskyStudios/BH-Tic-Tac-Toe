package org.bh.game.ttt;

import javafx.stage.Stage;
import org.bh.game.ttt.game.TicTacToeGameManager;
import org.bh.game.ttt.gui.FXGUI;
import org.bh.game.ttt.gui.comps.FXFrame;

/**
 * Application, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 *		- 2014-09-24 (1.0.0) - Kyli created Application
 * @since 2014-09-24
 */
public class Application extends javafx.application.Application
{
	private TicTacToeGameManager gameManager;
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		gameManager = new TicTacToeGameManager();
		primaryStage.setScene(new FXGUI());
		primaryStage.show();
		launch();
		gameManager.startGame();
	}
	
}
