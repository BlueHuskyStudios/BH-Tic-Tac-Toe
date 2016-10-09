package org.bh.game.ttt.gui.comps;

import javafx.stage.Stage;
import org.bh.game.ttt.evt.*;

import javax.swing.*;
import java.awt.*;

import static org.bh.game.ttt.CompiletimeConstants.*;
import static org.bh.game.ttt.RuntimeConstantsWrapper.*;

/**
 * FXFrame, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
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
	@SuppressWarnings("ConstantConditions") private void initGUI()
	{
		{
			/* Moved to FXApplication.java
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
					appMenu = new JMenu(RuntimeConstants.getAPP_NAME_ABBR());
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
