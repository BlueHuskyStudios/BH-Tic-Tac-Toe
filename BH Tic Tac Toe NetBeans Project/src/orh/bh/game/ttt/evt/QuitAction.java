package orh.bh.game.ttt.evt;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import orh.bh.game.ttt.Main;

/**
 * QuitAction, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 CC 3.0 BY-SA<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class QuitAction extends AbstractAction
{

	public QuitAction()
	{
		super(Main.lang.get("menu.app.quit", "Quit"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
