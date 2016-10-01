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

	private JMenuBar _menuBar;
	private JMenu    _appMenu;
	private void initGUI(TicTacToeGameManager gameManager)
	{
		{
			TicTacToeGrid grid = gameManager.grid();
			_swingGui = new SwingGUI(grid);
			setContentPane(_swingGui);
			addWindowListener(this);
		}
		{
            _menuBar = getJMenuBar();
			if (_menuBar == null)
                _menuBar = new JMenuBar();
			{
				if (_menuBar.getMenuCount() >= 1)
				{
                    _appMenu = _menuBar.getMenu(0);
				}
				else
				{
                    _appMenu = new JMenu(Main.GAME_ABBR);
					_menuBar.add(_appMenu);
				}
				JMenuItem startGameMenuItem = new JMenuItem(new StartGameAction(gameManager));
				_appMenu.add(startGameMenuItem);

				JMenuItem quitMenuItem = new JMenuItem(new QuitAction());
				_appMenu.add(quitMenuItem);
			}
			setJMenuBar(_menuBar);
		}

		pack();
        setMinimumSize(getSize());
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
