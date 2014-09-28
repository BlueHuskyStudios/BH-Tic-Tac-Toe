package org.bh.game.ttt.evt;

import java.util.EventListener;

/**
 * GameStateChangeListener, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
		- 2014-09-24 (1.0.0) - Kyli created GameStateChangeListener
 * @since 2014-09-24
 */
public interface GameStateChangeListener extends EventListener
{
	public void gameStateChanged(GameStateChangeEvent evt);
}
