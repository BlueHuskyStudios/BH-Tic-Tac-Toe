package org.bh.game.ttt.game.state

/**
 * SubstateChange, made for BH Tic Tac Toe, is copyright Blue Husky Software ©2016 BH-1-PS <hr/>
 *
 * The difference between an old and a new sub-state
 *
 * @author Kyli of Blue Husky Software
 * @version 1.0.0
 *		- 2016-10-23 (1.0.0) - Kyli created SubstateChange
 * @since 2016-10-23
 */
data class SubstateChange<SubstateType>(val oldValue: SubstateType?, val newValue: SubstateType?)