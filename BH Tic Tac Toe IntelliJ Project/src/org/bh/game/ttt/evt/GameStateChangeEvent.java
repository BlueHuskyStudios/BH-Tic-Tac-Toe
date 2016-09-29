package org.bh.game.ttt.evt;

import java.util.EventObject;
import org.bh.game.ttt.game.TicTacToeGameManager.GameState;

/**
 * GameStateChangeEvent, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 *		- 2014-09-24 (1.0.0) - Kyli created GameStateChangeEvent
 * @since 2014-09-24
 */
public class GameStateChangeEvent extends EventObject
{
	public final GameState NEW_STATE;
	public final GameState OLD_STATE;

	public GameStateChangeEvent(GameState NEW_STATE, GameState OLD_STATE, Object source)
	{
		super(source);
		this.NEW_STATE = NEW_STATE;
		this.OLD_STATE = OLD_STATE;
	}
}
