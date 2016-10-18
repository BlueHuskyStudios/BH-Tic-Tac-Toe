package org.bh.game.ttt.evt;

import org.bh.game.ttt.game.TicTacToeGameManager.GameState
import java.util.*

/**
 * GameStateChangeEvent, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 2.0.0
 *		- 2016-10-10 (2.0.0) - Ben migrated to Kotlin
 *		- 2014-09-24 (1.0.0) - Kyli created GameStateChangeEvent
 * @since 2014-09-24
 */

class GameStateChangeEvent(val newState: GameState, val oldState: GameState, source: Any) : EventObject(source)
