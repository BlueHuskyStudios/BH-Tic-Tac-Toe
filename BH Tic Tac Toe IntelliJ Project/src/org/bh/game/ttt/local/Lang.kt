package org.bh.game.ttt.local;

import java.io.FileInputStream
import java.io.IOException
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Strings, made for BH Tic Tac Toe, is copyright Blue Husky Software ©2014 GPLv3<HR/>
 *
 * @author Kyli of Blue Husky Software
 * @version 1.1.0
 *          ! 1.1.0 (2016-10-09) - Ben updated Lang to work without BHToolbox version 1, cleaned up code
 *          . 1.0.0 (2014-09-22) - Kyli made Lang
 * @since 2014-09-22
 */
class Lang {
    private val LANG_CHANGE_LISTENERS = MutableArrayPP()
    private var map = Properties()
    private var locale: Locale? = null

    constructor() {
        try {
            setLocale(Locale.getDefault())
        } catch (ex: UnsupportedLanguageException) {
            Logger.getGlobal().log(Level.WARNING,
                    "Could not load language \""
                            + Locale.getDefault()
                            + "\", falling back to "
                            + Locale.ENGLISH,
                    ex)
            try {
                setLocale(Locale.ENGLISH)
            } catch (ex1: UnsupportedLanguageException) {
                Logger.getGlobal().log(Level.SEVERE, "No language found. In-game text may be strange.", ex1)
            }

        }

    }

    fun setLocale(newLocale: Locale): Lang {
        val old: Locale = locale
        locale = newLocale
        loadTranslationMap(newLocale)

        alertOfLanguageChange(old)
        return this
    }

    private fun loadTranslationMap(locale: Locale) {
        val newMap = Properties()
        val fis: FileInputStream
        try {
            val `in` = getExternalLanguageStream(locale)
            newMap.load(`in`)
            map = newMap
        } catch (ex: IOException) {
            throw UnsupportedLanguageException(locale, ex)
        }

    }

    private fun alertOfLanguageChange(old: Locale) {
        LANG_CHANGE_LISTENERS.removeNulls()
        val evt = LangChangeEvent(old, locale!!, this)
        for (langChangeListener in LANG_CHANGE_LISTENERS) {
            langChangeListener.languageChanged(evt)
        }
    }

    constructor(initLocale: Locale) {
        setLocale(initLocale)
    }

    @JvmOverloads operator fun get(key: CharSequence, fallback: String = key.toString()): String {
        if (map.containsKey(key)) {
            return map.getProperty(key.toString())
        }
        map.put(key, fallback)
        return fallback
    }

    companion object {
        val DEFAULT_LANGUAGE = Lang()
        val en_US = makeLangForLocale(Locale.US)

        private fun makeLangForLocale(locale: Locale): Lang {
            val ret: Lang
            try {
                ret = Lang(Locale.US)
            } catch (ex: UnsupportedLanguageException) {
                ret = Lang()
            }

            return ret
        }
    }
}
