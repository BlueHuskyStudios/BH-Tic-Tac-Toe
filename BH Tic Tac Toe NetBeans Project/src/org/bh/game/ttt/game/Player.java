package org.bh.game.ttt.game;

/**
 * Player, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 *		- 2014-09-23 (1.0.0) - Kyli created Player
 * @since 2014-09-23
 */
public class Player
{
	private String name;
	private char symbol;

	public Player(String name, char symbol)
	{
		this.name = name;
		this.symbol = symbol;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public char getSymbol()
	{
		return symbol;
	}

	public void setSymbol(char symbol)
	{
		this.symbol = symbol;
	}
	
}
