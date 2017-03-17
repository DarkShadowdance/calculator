package ru.loyol.calculator.calculator;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Andrew on 17.03.2017.
 */

public class Logger {
    public static final Logger LOGGER = new Logger();
    private static String tag;
    private boolean debug = false;
    public String currentMessage;

    public static Logger init(@NotNull String value){
        if (tag != value) tag = value;
        return LOGGER;
    };

    public Logger on(){this.debug = true; return this;};
    public Logger off(){this.debug = false; return this;};
    public Logger log(String... messages){
        StringBuilder stringBuilder = new StringBuilder();
        if (!debug) return this;
        for (String message : messages) {
            stringBuilder.append(message);
        }
        currentMessage = stringBuilder.toString();
        return this;
    };
    public void write(char type){
        if (this.currentMessage == null || this.currentMessage.length() == 0) return;
        switch (type) {
            case 'i': Log.i(this.tag, this.currentMessage); break;
            case 'e': Log.e(this.tag, this.currentMessage); break;
            default: Log.v(this.tag, this.currentMessage);
        }
    }
}
