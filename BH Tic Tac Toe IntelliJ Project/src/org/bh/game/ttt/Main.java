package org.bh.game.ttt;

/**
 * The main class for BH Tic Tac Toe
 *
 * @author Kyli of BLue Husky Programming
 * @version 1.1.0
 * @since 2014-09-21
 */
public class Main {
    static {
        TicTacToeApplication.Companion.setUpPlatform();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToeApplication.Companion.startWithArgs(args);
    }
}
