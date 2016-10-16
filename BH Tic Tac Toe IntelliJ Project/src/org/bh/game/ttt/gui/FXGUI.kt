package org.bh.game.ttt.gui;

import javafx.scene.Parent
import javafx.scene.Scene
import org.bh.game.ttt.gui.comps.FXTicTacToePanel

/**
 * GUI, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
class FXGUI(root: Parent?) : Scene(root) {

    constructor() : this(null) { }

    init {
        initGUI()
    }

    private var tttPanel: FXTicTacToePanel? = null
    private fun initGUI() {
        tttPanel = FXTicTacToePanel()
        root = tttPanel
    }
}
