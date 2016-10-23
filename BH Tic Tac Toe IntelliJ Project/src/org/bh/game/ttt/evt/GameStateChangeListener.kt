package org.bh.game.ttt.evt

import java.util.*

/**
 * GameStateChangeListener, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Software ©2014 GPLv3 <hr/>
 *
 * @author Kyli & Ben of Blue Husky Software
 * @version 2.0.0
 *          ! 2016-10-10 (2.0.0) - Ben migrated to Kotlin
 *          . 2014-09-24 (1.0.0) - Kyli created GameStateChangeListener
 * @since 2014-09-24
 */
interface GameStateChangeListener : EventListener {
    fun gameStateChanged(evt: GameStateChangeEvent)
}
