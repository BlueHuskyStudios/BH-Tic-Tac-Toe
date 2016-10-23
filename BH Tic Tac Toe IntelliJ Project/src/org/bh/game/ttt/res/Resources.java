package org.bh.game.ttt.res;


import java.io.*;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bh.game.ttt.RuntimeConstantsWrapper.*;
import static org.bh.tools.serialization.SerializationUtilsWrapper.*;

/**
 * Resources, made for BH Tic Tac Toe NetBeans Project, is copyright Blue Husky Software ©2014 GPLv3<HR/>
 *
 * @author Kyli of Blue Husky Software
 * @version 1.0.0
 * @since 2014-09-23
 */
@SuppressWarnings("WeakerAccess")
public class Resources {
    /** Represents the directory where resources are stored. Should be {@code "/org/bh/game/ttt/res"} */
    public static final String RESOURCE_DIR;
    /** Represents the extension used for language files: <code>{@value}</code> */
    public static final String LANG_FILE_EXT = "lang";

    static {
        RESOURCE_DIR = '/' + Resources.class.getPackage().getName().replace('.', '/') + '/';
    }

    /**
     * Returns the language file stream for the given locale. If it has already been extracted, the extracted one is
     * returned. Else, it is extracted first.
     *
     * @param locale the locale
     *
     * @return the language file stream for the given locale
     *
     * @throws IOException if the stream could not be created or opened
     */
    public static InputStream getExternalLanguageStream(Locale locale) throws IOException {
        File extracted = SerializationUtils.saveFileFor(RuntimeConstants.getAPP_NAME(), locale.toLanguageTag() + ".lang");
        System.out.println("Loading language from " + extracted);
        if (!extracted.exists()) {
            // if we haven't extracted it from this JAR, we should do that first
            System.out.println("Language not yet extracted. Extracting...");
            extractLanguageFile(locale, extracted);
        }

        return new FileInputStream(extracted);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored") // I don't really care if the files were there before I made them
    private static void extractLanguageFile(Locale locale, File target) {
        InputStream    in                 = Resources.getInternalLanguageStream(locale);
        BufferedReader reader             = new BufferedReader(new InputStreamReader(in));
        String         extractFailMessage = "Cannot extract language file for " + locale;
        boolean        creationSuccess    = target.getParentFile().mkdirs();

        if (!creationSuccess) {
            Logger.getGlobal().severe(extractFailMessage);
            return;
        }
        try {
            target.createNewFile();
            final FileWriter writer = new FileWriter(target);
            reader.lines().forEach((str) -> {
                    try {
                        writer.write(str + "\r\n");
                    } catch (IOException ex) {
                        Logger.getGlobal().log(Level.SEVERE, extractFailMessage, ex);
                    }
                }
            );
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getGlobal().log(Level.SEVERE, extractFailMessage, ex);
        }
    }

    public static InputStream getInternalLanguageStream(Locale locale) {
        return Resources.class.getResourceAsStream(RESOURCE_DIR + locale.toLanguageTag() + "." + LANG_FILE_EXT);
    }
}
