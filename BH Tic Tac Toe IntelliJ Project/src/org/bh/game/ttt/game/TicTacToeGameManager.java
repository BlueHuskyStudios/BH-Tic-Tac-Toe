package org.bh.game.ttt.game;

import org.bh.game.ttt.evt.*;
import org.bh.tools.util.*;

import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bh.game.ttt.game.TicTacToeGameManager.GameState.*;

/**
 * TicTacToeGameManager, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0 - 2014-09-23 (1.0.0) - Kyli created TicTacToeGameManager
 * @since 2014-09-23
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class TicTacToeGameManager {
    private TicTacToeGrid                    grid;
    private Thread                           gameLoopThread;
    private boolean                          isPlaying;
    private MutableArrayPP<Player>                  players = generateNewPlayers(2);

    private MutableArrayPP<Player> generateNewPlayers(int numberOfPlayers) {
        return new MutableArrayPP<Player>(numberOfPlayers,
                (int idx) -> new Player("Player " + (idx + 1), (char) ('a' + idx)));
    }

    private MutableArrayPP<GameStateChangeListener> gscls = new MutableArrayPP<>();
    private GameState state = LOADING;

    public TicTacToeGameManager() {
        gameLoopThread = new Thread(() ->
        {
            synchronized (TicTacToeGameManager.this) {
                int size = players.length() + 1;
                grid = new TicTacToeGrid(size, size);

                setGameState(PLAYING);

                while (isPlaying) {
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        Logger.getGlobal().log(Level.SEVERE, "java.lang.InterruptedException caught!", e);
                    }
                }

                if (null != _gameplayStopListener) {
                    _gameplayStopListener.gameplayDidStop();
                }
            }
        }, "BH Tic Tac Toe game loop");

        setGameState(LOADED);
    }

    public TicTacToeGameManager addPlayer(Player newPlayer) {
        players.add(newPlayer);
        return this;
    }

    public void startGame() {
        isPlaying = true;
        setGameState(STARTING);
        if (!gameLoopThread.isAlive()) {
            gameLoopThread.start();
        }
    }

    private GameplayStopListener _gameplayStopListener;

    public void stopPlaying(GameplayStopListener callback) {
        _gameplayStopListener = callback;
        isPlaying = false;
    }

    public boolean setGameState(GameState newState) {
        if (state.isValidNextState(newState)) {
            GameState oldState = state;
            state = newState;
            alertOfStateChange(oldState, newState);
            return true;
        }
        Logger.getGlobal().warning("Cannot go from " + state + " to " + newState);
        return false;
    }

    private void alertOfStateChange(GameState oldState, GameState newState) {
        GameStateChangeEvent evt = new GameStateChangeEvent(newState, oldState, this);
        for (GameStateChangeListener stateChangeListener : gscls) {
            if (stateChangeListener == null) { gscls.removeNulls(); } else {
                stateChangeListener.gameStateChanged(evt);
            }
        }
    }

    public TicTacToeGameManager addStateChangeListener(GameStateChangeListener newStateChangeListener) {
        if (null == newStateChangeListener) {
            return this;
        }
        gscls.add(newStateChangeListener);
        newStateChangeListener.gameStateChanged(new GameStateChangeEvent(state, state, this));
        return this;
    }

    public TicTacToeGrid grid() {
        return grid;
    }

    public enum GameState {
        LOADING,
        LOADED,
        WAITING,
        STARTING,
        PLAYING,
        STOPPING;

        public boolean isValidNextState(GameState possibleNext) {
            switch (this) {
                case LOADING:
                    switch (possibleNext) {
                        case LOADING:
                        case LOADED:
                            return true;
                    }
                    return false;
                case LOADED:
                    switch (possibleNext) {
                        case LOADED:
                        case WAITING:
                        case STARTING:
                            return true;
                    }
                    return false;
                case WAITING:
                    switch (possibleNext) {
                        case WAITING:
                        case STARTING:
                            return true;
                    }
                    return false;
                case STARTING:
                    switch (possibleNext) {
                        case WAITING:
                        case STARTING:
                        case PLAYING:
                            return true;
                    }
                    return false;
                case PLAYING:
                    switch (possibleNext)
                    {
                        case PLAYING:
                        case STOPPING:
                            return true;
                    }
                    return false;
                case STOPPING:
                    switch (possibleNext)
                    {
                        case STOPPING:
                        case WAITING:
                        case LOADING:
                            return true;
                    }
                    return false;
                default:
                    throw new AssertionError("How did you even pass " + possibleNext + "?");
            }
        }
    }

    @SuppressWarnings("WeakerAccess")
    public interface GameplayStopListener extends ActionListener {
        void gameplayDidStop();
    }
}
