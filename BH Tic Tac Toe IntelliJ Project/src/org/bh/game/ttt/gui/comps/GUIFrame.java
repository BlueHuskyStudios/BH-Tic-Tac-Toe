package org.bh.game.ttt.gui.comps;

import org.bh.game.ttt.*;
import org.bh.game.ttt.evt.*;
import org.bh.game.ttt.game.*;
import org.bh.game.ttt.gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GUIFrame, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class GUIFrame extends JFrame implements WindowListener
{
	private SwingGUI _swingGui;

	public GUIFrame(TicTacToeGameManager gameManager) throws HeadlessException
	{
		initGUI(gameManager);
	}

	private JMenuBar jmb;
	private JMenu appMenu;
	private void initGUI(TicTacToeGameManager gameManager)
	{
		{
			TicTacToeGrid grid = gameManager.grid();
			_swingGui = new SwingGUI(grid);
			setContentPane(_swingGui);
			addWindowListener(this);
		}
		{
			jmb = getJMenuBar();
			if (jmb == null)
				jmb = new JMenuBar();
			{
				if (jmb.getMenuCount() >= 1)
				{
					appMenu = jmb.getMenu(0);
				}
				else
				{
					appMenu = new JMenu(Main.GAME_ABBR);
					jmb.add(appMenu);
				}
				JMenuItem quitMenuItem = new JMenuItem(new QuitAction());
				appMenu.add(quitMenuItem);
			}
			setJMenuBar(jmb);
		}

		pack();
	}

	@Override
	public void windowOpened(WindowEvent e){}

	@Override
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}

	@Override public void windowClosed(WindowEvent e){}
	@Override public void windowIconified(WindowEvent e){}
	@Override public void windowDeiconified(WindowEvent e){}
	@Override public void windowActivated(WindowEvent e){}
	@Override public void windowDeactivated(WindowEvent e){}
}
