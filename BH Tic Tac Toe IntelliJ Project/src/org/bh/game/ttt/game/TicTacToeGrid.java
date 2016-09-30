package org.bh.game.ttt.game;

import org.bh.tools.struct.coord.*;
import org.bh.tools.util.*;

/**
 * TicTacToeGrid, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0 - 2014-09-24 (1.0.0) - Kyli created TicTacToeGrid
 * @since 2014-09-24
 */
public class TicTacToeGrid {
    private final TicTacToeSquare[][] squares;
    private       Size<Integer>       _size;

    @SuppressWarnings("") // suppress all warnings
    public TicTacToeGrid(int width, int height) {
        _size = new Size<>(width, height);
        squares = new TicTacToeSquare[height][width];
        for (int row = 0; row < squares.length; row++) {
            for (int col = 0; col < squares[row].length; col++) { squares[row][col] = new TicTacToeSquare(); }
        }
    }

    public TicTacToeSquare getSquare(int row, int col) {
        return squares[row][col];
    }

    public Size<Integer> size() {
        return _size;
    }

    public TicTacToeSquare[][] squareRows() {
        return squares;
    }

    public static class TicTacToeSquare {
        private Player                                        occupant;
        private MutableArrayPP<TicTacToeSquareChangeListener> _listeners;

        public Player getOccupant() {
            return occupant;
        }

        public void setOccupant(Player newOccupant) {
            occupant = newOccupant;
        }

        public boolean isOccupied() {
            return occupant != null;
        }

        @Override
        public String toString() {
            return Character.toString(occupant.getSymbol());
        }

        public void addChangeListener(TicTacToeSquareChangeListener listener) {
            if (null == listener) {
                return;
            }
            _listeners.add(listener);
            listener.squareDidChange(new TicTacToeSquareChangeEvent(null, this));
        }

        public static interface TicTacToeSquareChangeListener {
            public void squareDidChange(TicTacToeSquareChangeEvent change);
        }



        /**
         * Describes an event wherein a Tic Tac Toe square changed.
         */
        public static class TicTacToeSquareChangeEvent {
            /**
             * The value before the change. This might be {@code null} if this is a notification of the initial value.
             */
            public final TicTacToeSquare OLD_VALUE;
            /**
             * The value after the change
             */
            public final TicTacToeSquare NEW_VALUE;

            public TicTacToeSquareChangeEvent(TicTacToeSquare OLD_VALUE, TicTacToeSquare NEW_VALUE) {
                this.OLD_VALUE = OLD_VALUE;
                this.NEW_VALUE = NEW_VALUE;
            }
        }
    }
}
