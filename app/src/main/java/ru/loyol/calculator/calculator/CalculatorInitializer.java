package ru.loyol.calculator.calculator;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Message;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;


/**
 * Created by Andrew on 17.03.2017.
 */

public class CalculatorInitializer {
    public static Pattern load(Activity activity) {
        Log.i(MainActivity.TAG, "load");
        Resources resources = activity.getResources();
        XmlResourceParser xmlParser = resources.getXml(R.xml.template);
        try {

            int index = xmlParser.next();
            while (index != XmlPullParser.END_DOCUMENT) {
                if (index==XmlPullParser.START_TAG && xmlParser.getName().contentEquals("template")){
                    Log.i(MainActivity.TAG, xmlParser.getName() + "::" + xmlParser.getAttributeCount());
                    String name = new String();
                    Integer priority = null;
                    for (int i = 0; i < xmlParser.getAttributeCount(); i++) {
                        switch (xmlParser.getAttributeName(i))
                        {
                            case "name": name = xmlParser.getAttributeValue(i); break;
                            case "priority": priority = Integer.getInteger(xmlParser.getAttributeValue(i)); break;
                        }
                    }
                    Pattern pattern = new Pattern(name, priority, null);
                    return pattern;
                };
                index = xmlParser.next();
            }
        } catch (Exception e) {
            Log.e(MainActivity.TAG, e.getMessage());
        }
        return null;
    };

}
