package orh.bh.game.ttt.gui.comps;

import bht.tools.comps.BHCompUtilities;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import orh.bh.game.ttt.Main;
import orh.bh.game.ttt.evt.QuitAction;
import orh.bh.game.ttt.gui.GUI;

/**
 * GUIFrame, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 CC 3.0 BY-SA<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class GUIFrame extends JFrame
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
		}
		{
			jmb = getJMenuBar();
			if (jmb == null)
				jmb = new JMenuBar();
			if (jmb.getMenuCount() >= 1)
			{
				appMenu = jmb.getMenu(0);
			}
			else if (jmb.getMenuCount() == 0)
			{
				appMenu = new JMenu(Main.GAME_ABBR);
				JMenuItem quitMenuItem = new JMenuItem(new QuitAction());
			}
			setJMenuBar(jmb);
		}
	}
}
