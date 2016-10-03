package org.bh.game.ttt.gui.comps

import org.bh.game.ttt.game.TicTacToeGrid
import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JLabel

/**
 * Copyright BHStudios ©2016 BH-1-PS. Made for BH Tic Tac Toe IntelliJ Project.
 *
 * @author Ben Leggiero
 * @since 2016-09-29
 */
class TicTacToeSquareView(val model: TicTacToeGrid.TicTacToeSquare): JComponent() {
    val label: JLabel by lazy { JLabel() }

    init {
        model.addChangeListener { event ->
            if (null == event.NEW_VALUE.occupant) {
                label.text = "?"
            } else {
                label.text = event.NEW_VALUE.occupant!!.symbol.toString()
            }
        }

        initGUI()
    }

    fun initGUI() {
        layout = BorderLayout()
        add(label, BorderLayout.CENTER)
    }
}