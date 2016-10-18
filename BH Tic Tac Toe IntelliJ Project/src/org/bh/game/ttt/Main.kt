package org.bh.game.ttt;

/**
 * The main class for BH Tic Tac Toe
 *
 * @author Kyli and Ben of BLue Husky Programming
 * @version 2.0.0
 * @since 2014-09-21
 */
object Main {
    init {
        TicTacToeApplication.setUpPlatform()
    }

    /**
     * @param args the command line arguments
     */
    @JvmStatic fun main(args: Array<String>) {
        TicTacToeApplication.startWithArgs(args)
    }
}

