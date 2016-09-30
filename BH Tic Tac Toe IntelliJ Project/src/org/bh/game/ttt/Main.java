package org.bh.game.ttt;

import bht.tools.comps.BHCompUtilities;
import bht.tools.util.StringPP;
import org.bh.game.ttt.gui.comps.*;
import org.bh.game.ttt.local.*;
import org.bh.tools.struct.*;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	public static final String  GAME_NAME        = "BH Tic Tac Toe";
	/**
	 * The abbreviation of the name of the game is {@code "BHTTT"}
	 */
	public static final String  GAME_ABBR        = new StringPP(GAME_NAME).toAbbreviation().toString();
	/**
	 * The version of the game is {@code 1.0.0}
	 */
	public static final Version GAME_VERSION     = new Version(1,0,0);
	/**
	 * The string form of the version of the game is {@code 1.0.0}
	 */
	public static final String  GAME_VERSION_STR = GAME_VERSION.toString();
	/** The language to display the game in */
	public static Lang lang;
	
	
	
	static
	{
		BHCompUtilities.setUsesOSMenuBar(true, Main.GAME_NAME);
		lang = new Lang();
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.ALL);
		Logger.getGlobal().addHandler(ch);
		Logger.getGlobal().setLevel(Level.ALL);
	}

	
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		System.out.println("Starting " + GAME_NAME + " " + GAME_VERSION + " (" + GAME_ABBR + "_" + GAME_VERSION_STR + ")");
		try
		{
			Application a = new Application();
			a.start(new FXFrame());
		}
		catch (Throwable t)
		{
			Logger.getGlobal().log(Level.FINE, "Cannot init FX. Reverting to Swing", t);
			SwingApplication a = new SwingApplication();
			a.start();
		}
	}
}
