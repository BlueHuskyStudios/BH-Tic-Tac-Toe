package org.bh.game.ttt.game.state

/**
 * TicTacToeGameState, made for BH Tic Tac Toe, is copyright Blue Husky Software ©2016 BH-1-PS <hr/>
 *
 * The complete state of the game at any given time
 *
 * @author Kyli of Blue Husky Software
 * @version 1.0.0
 *		- 2016-10-23 (1.0.0) - Kyli created TicTacToeGameState
 * @since 2016-10-23
 */
data class TicTacToeGameState(val majorState: MajorGameState = MajorGameState.Loading)