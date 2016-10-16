package org.bh.game.ttt;

import javafx.application.Application
import javafx.stage.Stage
import org.bh.game.ttt.game.TicTacToeGameManager
import org.bh.game.ttt.gui.FXGUI
import org.bh.game.ttt.gui.comps.FXFrame

/**
 * FXApplication, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 *
 * @author Kyli & Ben of Blue Husky Programming
 * @version 2.0.0
 *          - 2016-10-10 (2.0.0) - Ben migrated to Kotlin
 *          - 2014-09-24 (1.0.0) - Kyli created FXApplication
 * @since 2014-09-24
 */
class FXApplication : javafx.application.Application() {
    private var gameManager: TicTacToeGameManager? = null

    @Throws(Exception::class)
    fun start() {
        start(FXFrame())
    }

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        gameManager = TicTacToeGameManager()
        primaryStage.scene = FXGUI()
        primaryStage.show()
        Application.launch()
        gameManager!!.startGame()
    }
}
