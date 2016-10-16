package org.bh.game.ttt.game;

import org.bh.game.ttt.evt.GameStateChangeEvent
import org.bh.game.ttt.evt.GameStateChangeListener
import org.bh.game.ttt.game.GameState.*
import org.bh.tools.util.MutableArrayPP
import java.awt.event.ActionListener
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.concurrent.fixedRateTimer

/**
 * TicTacToeGameManager, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0 - 2014-09-23 (1.0.0) - Kyli created TicTacToeGameManager
 * @since 2014-09-23
 */
@SuppressWarnings("unused", "WeakerAccess")
class TicTacToeGameManager {
    private var grid: TicTacToeGrid? = null
    private val gameLoopThread: Timer
    private var isPlaying: Boolean = false
    private val players = generateNewPlayers(2)

    private fun generateNewPlayers(numberOfPlayers: Int): MutableArrayPP<Player> {
        return MutableArrayPP<Player>(numberOfPlayers,
                { idx: Int -> __TEST__Player("Player " + (idx + 1), ('a' + idx).toChar()) })
    }

    private val _changeListeners = MutableArrayPP<GameStateChangeListener>()
    private var _state = LOADING

    init {
        gameLoopThread =
                fixedRateTimer(
                        name = "BH Tic Tac Toe game loop",
                        daemon = false,
                        initialDelay = 0L,
                        period = 1000,
                        action = {
                            synchronized(this@TicTacToeGameManager) {
                                val size = players.length() + 1
                                grid = TicTacToeGrid(size, size)

                                setGameState(PLAYING)

                                while (isPlaying) {
                                    try {
                                        // do the thing
                                    } catch (e: InterruptedException) {
                                        Logger.getGlobal().log(Level.SEVERE, "java.lang.InterruptedException caught!", e)
                                    }

                                }

                                if (null != _gameplayStopListener) {
                                    _gameplayStopListener!!.gameplayDidStop()
                                }
                            }
                        })

        setGameState(LOADED)
    }

    fun addPlayer(newPlayer: Player): TicTacToeGameManager {
        players.add(newPlayer)
        return this
    }

    fun startGame() {
        isPlaying = true
        setGameState(STARTING)
        if (!gameLoopThread.isAlive) {
            gameLoopThread.start()
        }
    }

    private var _gameplayStopListener: GameplayStopListener? = null

    fun stopPlaying(callback: GameplayStopListener) {
        _gameplayStopListener = callback
        isPlaying = false
    }

    fun setGameState(newState: GameState): Boolean {
        if (_state.isValidNextState(newState)) {
            val oldState = _state
            _state = newState
            alertOfStateChange(oldState, newState)
            return true
        }
        Logger.getGlobal().warning("Cannot go from $_state to $newState")
        return false
    }

    private fun alertOfStateChange(oldState: GameState, newState: GameState) {
        val evt = GameStateChangeEvent(newState, oldState, this)
        for (stateChangeListener in _changeListeners) {
            if (stateChangeListener == null) {
                _changeListeners.removeNulls()
            } else {
                stateChangeListener.gameStateChanged(evt)
            }
        }
    }

    fun addStateChangeListener(newStateChangeListener: GameStateChangeListener?): TicTacToeGameManager {
        if (null == newStateChangeListener) {
            return this
        }
        _changeListeners.add(newStateChangeListener)
        newStateChangeListener.gameStateChanged(GameStateChangeEvent(_state, _state, this))
        return this
    }


    @SuppressWarnings("WeakerAccess")
    interface GameplayStopListener : ActionListener {
        fun gameplayDidStop()
    }
}

enum class GameState {
    LOADING,
    LOADED,
    WAITING,
    STARTING,
    PLAYING,
    STOPPING;

    fun isValidNextState(possibleNext: GameState): Boolean {
        when (this) {
            LOADING -> {
                when (possibleNext) {
                    LOADING, LOADED -> return true
                    WAITING, STARTING, PLAYING, STOPPING -> return false
                }
            }
            LOADED -> {
                when (possibleNext) {
                    LOADED, WAITING, STARTING -> return true
                    LOADING, PLAYING, STOPPING -> return false
                }
            }
            WAITING -> {
                when (possibleNext) {
                    WAITING, STARTING -> return true
                    LOADING, LOADED, PLAYING, STOPPING -> return false
                }
            }
            STARTING -> {
                when (possibleNext) {
                    WAITING, STARTING, PLAYING -> return true
                    LOADING, LOADED, STOPPING -> return false
                }
            }
            PLAYING -> {
                when (possibleNext) {
                    PLAYING, STOPPING -> return true
                    LOADING, LOADED, WAITING, STARTING -> return false
                }

            }
            STOPPING -> {
                when (possibleNext) {
                    STOPPING, WAITING, LOADING -> return true
                    LOADED, STARTING, PLAYING -> return false
                }

            }
        }
    }
}
