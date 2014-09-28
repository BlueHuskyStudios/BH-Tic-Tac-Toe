package org.bh.game.ttt.gui.comps;

import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static org.bh.game.ttt.Constants.D;
import org.bh.game.ttt.Main;
import org.bh.game.ttt.evt.QuitAction;
import org.bh.game.ttt.gui.FXGUI;

/**
 * GUIFrame, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class FXFrame extends Stage
{
//	private FXGUI gui;

	public FXFrame() throws HeadlessException
	{
		super(null);
		initGUI();
	}

	private JMenuBar jmb;
	private JMenu appMenu;
	private void initGUI()
	{
		{
			/* Moved to Application.java
			gui = new FXGUI();
			setScene(gui);*/
			
//			setContentPane(gui);
//			addWindowListener(this);
		}
		if (8==D)
		{
			jmb = null;//getJMenuBar();
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
//			setJMenuBar(jmb);
		}
	}

	/*@Override
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
	@Override public void windowDeactivated(WindowEvent e){}*/
}
