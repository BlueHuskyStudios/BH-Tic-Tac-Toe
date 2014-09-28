package org.bh.game.ttt.game;

/**
 * TicTacToeGrid, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 *		- 2014-09-24 (1.0.0) - Kyli created TicTacToeGrid
 * @since 2014-09-24
 */
public class TicTacToeGrid
{
	private final TicTacToeSquare[][] squares;
	
	@SuppressWarnings("") // suppress all warnings
	public TicTacToeGrid(int width, int height)
	{
		squares = new TicTacToeSquare[height][width];
		for (int row = 0; row < squares.length; row++)
			for (int col = 0; col < squares[row].length; col++)
				squares[row][col] = new TicTacToeSquare();
	}
	
	public TicTacToeSquare getSquare(int row, int col)
	{
		return squares[row][col];
	}

	public static class TicTacToeSquare
	{
		private Player occupant;

		public Player getOccupant()
		{
			return occupant;
		}

		public void setOccupant(Player newOccupant)
		{
			occupant = newOccupant;
		}
		
		public boolean isOccupied()
		{
			return occupant != null;
		}

		@Override
		public String toString()
		{
			return Character.toString(occupant.getSymbol());
		}
	}
}
