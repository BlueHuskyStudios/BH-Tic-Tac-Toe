package org.bh.game.ttt.game;

import java.awt.Point;

/**
 * AI, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 *		- 2014-09-23 (1.0.0) - Kyli created AI
 * @since 2014-09-23
 */
public class AI extends Player
{
	public AI(String name, char symbol)
	{
		super(name, symbol);
	}

	@Override
	public Move nextMove()
	{
		return new Move(0, 0);
	}
}
