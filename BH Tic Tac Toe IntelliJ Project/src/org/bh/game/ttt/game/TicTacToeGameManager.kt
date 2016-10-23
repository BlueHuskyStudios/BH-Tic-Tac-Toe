package org.bh.game.ttt.game

import org.bh.game.ttt.game.state.TicTacToeGameState

/**
 * TicTacToeManager, made for BH Tic Tac Toe, is copyright Blue Husky Software ©2016 BH-1-PS <hr/>
 *
 * @author Kyli, Ben of Blue Husky Software
 * @version 3.0.0
 *		- 2016-10-23 (3.0.0) - Kyli re-created to be more fluxy
 *		- 2016-10-10 (2.0.0) - Ben migrated to Kotlin
 *		- 2014-09-24 (1.0.0) - Kyli created GameStateChangeEvent
 * @since 2014-09-24
 */
class TicTacToeGameManager {
    val gameState = TicTacToeGameState()
    val gameStateHistory = HistoryArray<TicTacToeGameState>()
}

