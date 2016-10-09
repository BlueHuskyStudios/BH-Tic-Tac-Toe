package org.bh.game.ttt.local;

import bht.tools.util.ArrayPP;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bh.game.ttt.res.Resources.*;

/**
 * Strings, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 *
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 * @since 2014-09-22
 */
public class Lang {
    private final ArrayPP<LangChangeListener> LANG_CHANGE_LISTENERS = new ArrayPP<>();
    //	private HashMap<CharSequence, String> map = new HashMap<>();
    private Properties map = new Properties();
    private Locale locale;
    @NotNull public static final Lang defaultLanguage = new Lang();
    @NotNull public static final Lang en_US = makeLangForLocale(Locale.US);

    private static Lang makeLangForLocale(Locale locale) {
        Lang ret;
        try {
            ret = new Lang(Locale.US);
        } catch (UnsupportedLanguageException ex) {
            ret = new Lang();
        }
        return ret;
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Lang() {
        try {
            setLocale(Locale.getDefault());
        } catch (UnsupportedLanguageException ex) {
            Logger.getGlobal()
                    .log(Level.WARNING,
                            "Could not load language \""
                            + Locale.getDefault()
                            + "\", falling back to "
                            + Locale.ENGLISH,
                            ex);
            try {
                setLocale(Locale.ENGLISH);
            } catch (UnsupportedLanguageException ex1) {
                Logger.getGlobal().log(Level.SEVERE, "No language found. In-game text may be strange.", ex1);
            }
        }
    }

    public Lang setLocale(Locale newLocale) throws UnsupportedLanguageException {
        Locale old = locale;
        locale = newLocale;
        loadTranslationMap(locale);

        alertOfLanguageChange(old);
        return this;
    }

    private void loadTranslationMap(Locale locale) throws UnsupportedLanguageException {
        Properties      newMap = new Properties();
        FileInputStream fis;
        try {
            InputStream in = getExternalLanguageStream(locale);
            newMap.load(in);
            map = newMap;
        } catch (IOException ex) {
            throw new UnsupportedLanguageException(locale, ex);
        }
    }

    private void alertOfLanguageChange(Locale old) {
        LANG_CHANGE_LISTENERS.trimInside();
        LangChangeEvent evt = new LangChangeEvent(old, locale, this);
        for (LangChangeListener langChangeListener : LANG_CHANGE_LISTENERS) { langChangeListener.languageChanged(evt); }
    }

    public Lang(Locale initLocale) throws UnsupportedLanguageException {
        setLocale(initLocale);
    }

    public String get(CharSequence key) {
        return get(key, String.valueOf(key));
    }

    public String get(CharSequence key, String fallback) {
        if (map.containsKey(key)) { return map.getProperty(String.valueOf(key)); }
        map.put(key, fallback);
        return fallback;
    }
}
