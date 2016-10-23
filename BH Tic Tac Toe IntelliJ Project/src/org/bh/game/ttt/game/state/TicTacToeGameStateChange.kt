package org.bh.game.ttt.game.state

import org.bh.game.ttt.game.state.MajorGameState
import org.bh.game.ttt.game.state.SubstateChange

data class TicTacToeGameStateChange(val majorStateChange: SubstateChange<MajorGameState>?)