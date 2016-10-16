package org.bh.game.ttt.game

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for BH Tic Tac Toe IntelliJ Project.
 *
 * @author Ben C. Leggiero
 * @since 2016-10-10
 */
abstract class Player(var name: String, var symbol: Char) {

    /**
     * Asks the player for their next move. This may be delayed indefinitely.
     */
    abstract fun nextMove(callback: MoveCallback)
}

class __TEST__Player(name: String, symbol: Char) : Player(name, symbol) {
    override fun nextMove(callback: (Move) -> Unit) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

typealias MoveCallback = (move: Move) -> Unit
