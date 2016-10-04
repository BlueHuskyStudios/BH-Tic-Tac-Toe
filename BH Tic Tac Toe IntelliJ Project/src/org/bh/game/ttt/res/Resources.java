package org.bh.game.ttt.res;

import bht.tools.util.save.general.SaveConstants;

import java.io.*;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bh.game.ttt.RuntimeConstantsWrapper.*;

/**
 * Resources, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-23
 */
public class Resources
{
	/** Represents the directory where resources are stored. Should be {@code "/org/bh/game/ttt/res"} */
	public static final String RESOURCE_DIR;
	/** Represents the extension used for language files: <code>{@value}</code> */
	public static final String LANG_FILE_EXT = "lang";
	
	static
	{
		RESOURCE_DIR = '/' + Resources.class.getPackage().getName().replace('.', '/') + '/';
	}

	public static InputStream getInternalLanguageStream(Locale locale)
	{
		return Resources.class.getResourceAsStream(RESOURCE_DIR + locale.toLanguageTag() + "." + LANG_FILE_EXT);
	}

	/**
	 * Returns the language file stream for the given locale. If it has already been extracted, the extracted one is returned.
	 * Else, it is extracted first.
	 * 
	 * @param locale the locale 
	 * @return
	 * @throws IOException 
	 */
	public static InputStream getExternalLanguageStream(Locale locale) throws IOException
	{
		
		File extracted = SaveConstants.inventSaveFileFor(RuntimeConstants.getAPP_NAME(),locale.toLanguageTag() + ".lang");
		System.out.println("Loading language from " + extracted);
		if (!extracted.exists())
		{
			// if we haven't extracted it from this JAR, we should do that first
			System.out.println("Language not yet extracted. Extracting...");
			extractLanguageFile(locale, extracted);
		}
		
		return new FileInputStream(extracted);
	}

	private static void extractLanguageFile(Locale locale, File target)
	{
		InputStream in = Resources.getInternalLanguageStream(locale);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		target.getParentFile().mkdirs();
		String extractFailMessage = "Cannot extract language file for " + locale;
		try
		{
			target.createNewFile();
			final FileWriter writer = new FileWriter(target);
			reader
				.lines()
				.forEach(
					(str) ->
					{
						try
						{
							writer.write(str + "\r\n");
						}
						catch (IOException ex)
						{
							Logger.getGlobal().log(Level.SEVERE, extractFailMessage, ex);
						}
					}
				)
			;
			writer.flush();
			writer.close();
		}
		catch (IOException ex)
		{
			Logger.getGlobal().log(Level.SEVERE, extractFailMessage, ex);
		}
	}
}
