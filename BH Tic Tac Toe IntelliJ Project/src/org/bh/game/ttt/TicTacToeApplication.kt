package org.bh.game.ttt

import bht.tools.comps.BHCompUtilities
import java.util.logging.ConsoleHandler
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for BH Tic Tac Toe IntelliJ Project.
 *
 * @author Ben Leggiero
 * @since 2016-10-03
 */
class TicTacToeApplication {
    companion object {
        /**
         * Call this before the main method. Best place is in the main class' `static` method.
         */
        fun setUpPlatform() {
            BHCompUtilities.setUsesOSMenuBar(true, RuntimeConstantsWrapper.APP_NAME)

            val consoleHandler = ConsoleHandler()
            consoleHandler.level = Level.ALL
            Logger.getGlobal().addHandler(consoleHandler)
            Logger.getGlobal().level = Level.ALL
        }

        /**
         * Starts the application.
         */
        fun startWithArgs(args: Array<String>) {
            System.out.println("Starting ${RuntimeConstantsWrapper.APP_NAME} ${RuntimeConstantsWrapper.GAME_VERSION} " +
                    "(${RuntimeConstantsWrapper.APP_NAME_ABBR}_${RuntimeConstantsWrapper.GAME_VERSION_STR})")

            try {
                FXApplication().start()
            } catch (t: Throwable) {
                SwingApplication().start()
            }
        }
    }
}
