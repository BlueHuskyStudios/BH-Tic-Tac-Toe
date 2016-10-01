package org.bh.game.ttt

import org.bh.game.ttt.game.TicTacToeGameManager
import org.bh.game.ttt.gui.comps.GUIFrame
import org.bh.tools.ui.LookAndFeelChanger
import org.bh.tools.ui.LookAndFeelEnum

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for BH Tic Tac Toe IntelliJ Project.
 *
 * @author BenLeggiero
 * @since 2016-09-29
 */
class SwingApplication(val gameManager: TicTacToeGameManager = TicTacToeGameManager(), val frame: GUIFrame = GUIFrame(gameManager)) {

    init {
        LookAndFeelChanger.setLookAndFeel(LookAndFeelEnum.Nimbus, false, { errorType ->
            // todo: handle
        })
    }

    fun start() {
        frame.isVisible = true
    }
}