package org.bh.game.ttt.local;

import java.util.EventObject;
import java.util.Locale;

/**
 * LangChangeEvent, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-22
 */
public class LangChangeEvent extends EventObject
{
	public final Locale OLD_LOCALE, NEW_LOCALE;

	public LangChangeEvent(Locale oldLocale, Locale newLocale, Object source)
	{
		super(source);
		OLD_LOCALE = oldLocale;
		NEW_LOCALE = newLocale;
	}
}
