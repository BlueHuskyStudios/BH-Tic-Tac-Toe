package org.bh.game.ttt

import bht.tools.util.StringPP
import org.bh.game.ttt.local.Lang
import org.bh.tools.func.Observing
import org.bh.tools.struct.Version

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for BH Tic Tac Toe IntelliJ Project.
 *
 * All sorts of things you gotta know at any time!
 *
 * @author Ben Leggiero
 * @since 2016-10-03
 */
class RuntimeConstantsWrapper {
    companion object RuntimeConstants {
        /**
         * The name of the game
         */
        val APP_NAME: String get() = lang.get("BH Tic Tac Toe")
        /**
         * The abbreviation of the name of the game
         */
        val APP_NAME_ABBR: String get() = StringPP(APP_NAME).toAbbreviation().toString()
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

    private constructor()
}