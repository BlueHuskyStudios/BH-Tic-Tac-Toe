package org.bh.game.ttt

import org.bh.game.ttt.game.TicTacToeGameManager
import org.bh.game.ttt.gui.comps.GUIFrame

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for BH Tic Tac Toe IntelliJ Project.
 *
 * @author BenLeggiero
 * @since 2016-09-29
 */
class SwingApplication(val gameManager: TicTacToeGameManager = TicTacToeGameManager(), val frame: GUIFrame = GUIFrame(gameManager)) {

    fun start() {
        frame.isVisible = true
    }
}