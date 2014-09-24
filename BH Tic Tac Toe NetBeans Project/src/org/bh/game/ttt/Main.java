package org.bh.game.ttt;

import bht.tools.comps.BHCompUtilities;
import bht.tools.util.ArrayPP;
import bht.tools.util.StringPP;
import bht.tools.util.upd.Version;
import org.bh.game.ttt.gui.GUI;
import org.bh.game.ttt.gui.comps.GUIFrame;
import org.bh.game.ttt.local.Lang;

/**
 * The main class for BH Tic Tac Toe
 *
 * @author Kyli of BLue Husky Programming
 * @version 1.0.0
 * @since 2014-09-21
 */
public class Main
{
	/**
	 * The name of the game is <code>{@value}</code>
	 */
	public static final String GAME_NAME = "BH Tic Tac Toe";
	/**
	 * The abbreviation of the name of the game is {@code "BHTTT"}
	 */
	public static final String GAME_ABBR = new StringPP(GAME_NAME).toAbbreviation().toString();
	/**
	 * The version of the game is {@code 1.0.0}
	 */
	public static final Version GAME_VERSION = new Version(1,0,0);
	/**
	 * The string form of the version of the game is {@code 1.0.0}
	 */
	public static final String GAME_VERSION_STR = GAME_VERSION.toString();
	/** The language to display the game in */
	public static Lang lang;
	
	
	
	static
	{
		BHCompUtilities.setUsesOSMenuBar(true, Main.GAME_NAME);
		lang = new Lang();
	}

	
	
	private static GUIFrame frame;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		System.out.println("Starting " + GAME_NAME + " " + GAME_VERSION + " (" + GAME_ABBR + "_" + GAME_VERSION_STR + ")");
		frame = new GUIFrame();
		frame.setVisible(true);
	}
}
