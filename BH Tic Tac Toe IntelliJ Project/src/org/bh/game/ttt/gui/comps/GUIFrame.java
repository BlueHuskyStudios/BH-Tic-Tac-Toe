package org.bh.game.ttt.gui.comps;

import bht.tools.comps.BHCompUtilities;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.bh.game.ttt.Main;
import org.bh.game.ttt.evt.QuitAction;
import org.bh.game.ttt.gui.GUI;

/**
 * GUIFrame, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class GUIFrame extends JFrame implements WindowListener
{
	private GUI gui;

	public GUIFrame() throws HeadlessException
	{
		initGUI();
	}

	private JMenuBar jmb;
	private JMenu appMenu;
	private void initGUI()
	{
		{
			gui = new GUI();
			setContentPane(gui);
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
