package org.bh.game.ttt.local;

import java.util.Locale;

/**
 * UnsupportedLanguageException, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-22
 */
class UnsupportedLanguageException extends Exception
{

	public UnsupportedLanguageException(Locale locale, Throwable cause)
	{
		super("Language not supported: " + locale, cause);
	}
	
}
