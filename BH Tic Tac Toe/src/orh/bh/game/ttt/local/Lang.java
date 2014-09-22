package orh.bh.game.ttt.local;

import bht.tools.util.ArrayPP;
import bht.tools.util.save.general.SaveConstants;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import orh.bh.game.ttt.Main;

/**
 * Strings, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 CC 3.0 BY-SA<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-22
 */
public class Lang
{
//	private HashMap<CharSequence, String> map = new HashMap<>();
	private Properties map = new Properties();
	private Locale locale;
	private ArrayPP<LangChangeListener> langChangeListeners = new ArrayPP<LangChangeListener>();

	@SuppressWarnings("OverridableMethodCallInConstructor")
	public Lang()
	{
		try
		{
			setLocale(Locale.getDefault());
		}
		catch (UnsupportedLanguageException ex)
		{
			Logger.getGlobal().log(Level.WARNING, "Could not load language \"" + Locale.getDefault() + "\", falling back to " + Locale.ENGLISH, ex);
			try
			{
				setLocale(Locale.ENGLISH);
			}
			catch (UnsupportedLanguageException ex1)
			{
				Logger.getLogger(Lang.class.getName()).log(Level.SEVERE, "No language found. In-game text may be strange.", ex1);
			}
		}
	}

	public Lang(Locale initLocale) throws UnsupportedLanguageException
	{
		setLocale(initLocale);
	}
	
	public String get(CharSequence key)
	{
		return get(key, String.valueOf(key));
	}

	public String get(CharSequence key, String fallback)
	{
		if (map.containsKey(key))
			return map.getProperty(String.valueOf(key));
		map.put(key, fallback);
		return fallback;
	}
	
	public Lang setLocale(Locale newLocale) throws UnsupportedLanguageException
	{
		Locale old = locale;
		locale = newLocale;
		loadTranslationMap(locale);
		
		alertOfLanguageChange(old);
		return this;
	}

	private void loadTranslationMap(Locale locale) throws UnsupportedLanguageException
	{
		Properties newMap = new Properties();
		FileInputStream fis;
		try
		{
			newMap.load(new FileInputStream(
				SaveConstants.inventSaveFileFor(Main.GAME_NAME, locale.toLanguageTag() + ".lang")));
			map = newMap;
		}
		catch (IOException ex)
		{
			throw new UnsupportedLanguageException(locale, ex);
		}
	}

	private void alertOfLanguageChange(Locale old)
	{
		langChangeListeners.trimInside();
		LangChangeEvent evt = new LangChangeEvent(old, locale, this);
		for (LangChangeListener langChangeListener : langChangeListeners)
			langChangeListener.languageChanged(evt);
	}
}
