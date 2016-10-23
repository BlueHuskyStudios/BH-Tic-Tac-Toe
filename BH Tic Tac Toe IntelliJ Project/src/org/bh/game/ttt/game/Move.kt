package org.bh.game.ttt.game;


import org.bh.tools.struct.coord.Point

/**
 * Move, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Software ©2014 GPLv3 <hr/>
 *
 * A singular move in a game of tic tac toe
 *
 * @author Kyli & Ben of Blue Husky Software
 *
 * @version 2.0.0
 *          ! 2016-10-10 (2.0.0) - Ben migrated Move to Kotlin
 *          . 2014-09-24 (1.0.0) - Kyli created Move
 * @since 2014-09-24
 */
data class Move(val oldPosition: Position, val newPosition: Position)

typealias Position = Point<Byte>

// FIXME: I'd love to make this accessible with the syntax Position.zero
val PositionZero: Position = Position(0, 0)