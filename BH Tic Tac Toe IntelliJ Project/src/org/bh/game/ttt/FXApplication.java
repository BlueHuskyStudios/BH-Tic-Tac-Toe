package org.bh.game.ttt;

import javafx.stage.Stage;
import org.bh.game.ttt.game.*;
import org.bh.game.ttt.gui.*;
import org.bh.game.ttt.gui.comps.*;

/**
 * FXApplication, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0 - 2014-09-24 (1.0.0) - Kyli created FXApplication
 * @since 2014-09-24
 */
public class FXApplication extends javafx.application.Application {
    private TicTacToeGameManager gameManager;

    public void start() throws Exception {
        start(new FXFrame());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameManager = new TicTacToeGameManager();
        primaryStage.setScene(new FXGUI());
        primaryStage.show();
        launch();
        gameManager.startGame();
    }

}
