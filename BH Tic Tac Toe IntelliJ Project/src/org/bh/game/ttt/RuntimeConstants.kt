package org.bh.game.ttt

import org.bh.game.ttt.local.Lang
import org.bh.tools.base.func.Observing
import org.bh.tools.base.struct.Version
import org.bh.tools.base.util.toAbbreviation

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for BH Tic Tac Toe IntelliJ Project.
 *
 * All sorts of things you gotta know at any time!
 *
 * @author Ben Leggiero
 * @since 2016-10-03
 */
class RuntimeConstantsWrapper
private constructor() {// Just keeping the singleton public
    companion object RuntimeConstants {
        /**
         * The name of the game
         */
        val APP_NAME: String get() = lang.get("BH Tic Tac Toe")

        /**
         * The abbreviation of the name of the game
         */
        val APP_NAME_ABBR: String get() = APP_NAME.toAbbreviation().toString()

        /**
         * The version of the game is `1.0.0`
         */
        val GAME_VERSION = Version(1, 0, 0)

        /**
         * The string form of the version of the game is `1.0.0`
         */
        val GAME_VERSION_STR = GAME_VERSION.toString()

        /** The language to display the game in  */
        var lang: Lang by Observing(Lang.en_US,
                willSet = { oldValue, newValue ->
                    // I dunno reload I guess
                })
    }
}