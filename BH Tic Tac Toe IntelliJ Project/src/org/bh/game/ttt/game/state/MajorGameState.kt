package org.bh.game.ttt.game.state

/**
 * MajorGameState, made for BH Tic Tac Toe, is copyright Blue Husky Software ©2016 BH-1-PS <hr/>
 *
 * The very general state of the game
 *
 * @author Kyli of Blue Husky Software
 * @version 1.0.0
 *		- 2016-10-23 (1.0.0) - Kyli created MajorGameState
 * @since 2016-10-23
 */
enum class MajorGameState {
    Loading,
    LoadedNotPlaying,
    Playing,
    Quitting
}