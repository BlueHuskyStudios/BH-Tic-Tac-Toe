package org.bh.game.ttt.local;

import java.util.EventListener;

public interface LangChangeListener extends EventListener
{
	public void languageChanged(LangChangeEvent evt);
}
