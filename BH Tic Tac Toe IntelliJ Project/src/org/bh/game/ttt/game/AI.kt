package org.bh.game.ttt.game;

/**
 * AI, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Software ©2014 GPLv3 <hr/>
 * 
 * @author Kyli & Ben of Blue Husky Software
 * @version 2.0.0
 *          - 2016-10-10 (2.0.0) - Ben migrated to Kotlin
 *          - 2014-09-23 (1.0.0) - Kyli created AI
 * @since 2014-09-23
 */
class AI(name: String, symbol: Char) : Player(name, symbol) {

    override fun nextMove(callback: Function1<Move, Unit>) {
        callback.invoke(Move(PositionZero, PositionZero))
    }
}
