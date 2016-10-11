package org.bh.game.ttt.local;

import org.bh.tools.util.*;
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
 * @version 1.1.0
 *          ! 1.1.0 (2016-10-09) - Ben updated Lang to work without BHToolbox version 1, cleaned up code
 *          . 1.0.0 (2014-09-22) - Kyli made Lang
 * @since 2014-09-22
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Lang {
    @NotNull public static final Lang                               DEFAULT_LANGUAGE      = new Lang();
    @NotNull public static final Lang                               en_US                 = makeLangForLocale(Locale.US);
    private final                MutableArrayPP<LangChangeListener> LANG_CHANGE_LISTENERS = new MutableArrayPP<>();
    private                      Properties                         map                   = new Properties();
    private Locale locale;

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
        LANG_CHANGE_LISTENERS.removeNulls();
        LangChangeEvent evt = new LangChangeEvent(old, locale, this);
        for (LangChangeListener langChangeListener : LANG_CHANGE_LISTENERS) { langChangeListener.languageChanged(evt); }
    }

    public Lang(Locale initLocale) throws UnsupportedLanguageException {
        setLocale(initLocale);
    }

    private static Lang makeLangForLocale(Locale locale) {
        Lang ret;
        try {
            ret = new Lang(Locale.US);
        } catch (UnsupportedLanguageException ex) {
            ret = new Lang();
        }
        return ret;
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
