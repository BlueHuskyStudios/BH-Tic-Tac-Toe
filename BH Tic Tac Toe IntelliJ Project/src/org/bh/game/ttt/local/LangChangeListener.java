package org.bh.game.ttt.local;

import java.util.EventListener;

@SuppressWarnings("WeakerAccess")
public interface LangChangeListener extends EventListener {
    void languageChanged(LangChangeEvent evt);
}
