package org.bh.game.ttt.local;

import java.util.*

/**
 * UnsupportedLanguageException, made for BH Tic Tac Toe, is copyright Blue Husky Software ©2014 GPLv3<HR/>
 * 
 * @author Kyli of Blue Husky Software
 * @version 2.0.0
 * @since 2014-09-22
 */
internal class UnsupportedLanguageException(locale: Locale, cause: Throwable) : Exception("Language not supported: " + locale, cause)
