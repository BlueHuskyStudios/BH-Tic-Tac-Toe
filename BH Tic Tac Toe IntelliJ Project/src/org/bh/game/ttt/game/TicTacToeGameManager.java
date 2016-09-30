package org.bh.game.ttt.game;

import bht.tools.util.ArrayPP;
import org.bh.game.ttt.evt.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TicTacToeGameManager, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0 - 2014-09-23 (1.0.0) - Kyli created TicTacToeGameManager
 * @since 2014-09-23
 */
public class TicTacToeGameManager {
    private TicTacToeGrid                    grid;
    private Thread                           gameLoopThread;
    private boolean                          isPlaying;
    private ArrayPP<Player>                  players;
    private ArrayPP<GameStateChangeListener> gscls;
    private GameState state = GameState.LOADING;

    public TicTacToeGameManager() {
        gameLoopThread = new Thread(() ->
        {
            int size = players.length() + 1;
            grid = new TicTacToeGrid(size, size);

            while (isPlaying) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    Logger.getGlobal().log(Level.SEVERE, "java.lang.InterruptedException caught!", e);
                }
            }
        }, "BH Tic Tac Toe game loop");

    }

    public TicTacToeGameManager addPlayer(Player newPlayer) {
        players.add(newPlayer);
        return this;
    }

    public void startGame() {
        gameLoopThread.start();
    }

    public TicTacToeGameManager setGameState(GameState newState) {
        if (state.isValidNextState(newState)) {
            GameState oldState = state;
            state = newState;
            alertOfStateChange(oldState, newState);
            return this;
        }
        throw new IllegalStateException("Cannot go from " + state + " to " + newState);
    }

    private void alertOfStateChange(GameState oldState, GameState newState) {
        GameStateChangeEvent evt = new GameStateChangeEvent(newState, oldState, this);
        for (GameStateChangeListener stateChangeListener : gscls) {
            if (stateChangeListener == null) { gscls.remove((GameStateChangeListener) null, true); } else {
                stateChangeListener.gameStateChanged(evt);
            }
        }
    }

    public TicTacToeGameManager addStateChangeListener(GameStateChangeListener newStateChangeListener) {
        gscls.add(newStateChangeListener);
        return this;
    }

    public TicTacToeGrid grid() {
        return grid;
    }

    public static enum GameState {
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
                            return true;
                    }
                case WAITING:
                    switch (possibleNext) {
                        case WAITING:
                        case STARTING:
                            return true;
                    }
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
                            return true;
                    }
                    return false;
                default:
                    throw new AssertionError("How did you even pass " + possibleNext + "?");
            }
        }
    }
}
