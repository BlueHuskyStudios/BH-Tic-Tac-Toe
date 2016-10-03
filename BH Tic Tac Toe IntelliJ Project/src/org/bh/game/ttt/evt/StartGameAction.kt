package org.bh.game.ttt.evt

import org.bh.game.ttt.game.TicTacToeGameManager
import java.awt.event.ActionEvent
import javax.swing.AbstractAction

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for BH Tic Tac Toe IntelliJ Project.
 *
 * @author Ben Leggiero
 * @since 2016-10-01
 */
class StartGameAction(val gameManager: TicTacToeGameManager): AbstractAction("New Game") {
    override fun actionPerformed(e: ActionEvent?) {
        gameManager.startGame()
    }
}
