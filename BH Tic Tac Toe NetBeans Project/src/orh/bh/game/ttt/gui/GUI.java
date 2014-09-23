package orh.bh.game.ttt.gui;

import javax.swing.JComponent;
import orh.bh.game.ttt.gui.comps.TicTacToePanel;

/**
 * GUI, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 CC 3.0 BY-SA<HR/>
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
		{
			tttPanel = new TicTacToePanel();
			add(tttPanel);
		}
	}
	
}
