package org.bh.game.ttt.local;

import java.util.*

/**
 * LangChangeEvent, made for BH Tic Tac Toe, is copyright Blue Husky Programming ©2014 GPLv3<HR/>
 * 
 * @author Kyli & Ben of Blue Husky Programming
 * @version 2.0.0
 * @since 2014-09-22
 */
class LangChangeEvent(val oldLocale: Locale, val newLocale: Locale, source: Any): EventObject(source)
