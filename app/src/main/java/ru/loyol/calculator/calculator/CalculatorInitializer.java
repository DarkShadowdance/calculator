package ru.loyol.calculator.calculator;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import org.xmlpull.v1.XmlPullParser;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andrew on 17.03.2017.
 */

public class CalculatorInitializer {
    public static List<Pattern> load(Activity activity) {
        Logger logger = Logger.init("MyActivity");
        List<Pattern> patterns = new ArrayList<>();
        Resources resources = activity.getResources();
        XmlResourceParser xmlParser = resources.getXml(R.xml.template);
        try {

            int index = xmlParser.next();
            while (index != XmlPullParser.END_DOCUMENT) {
                if (index==XmlPullParser.START_TAG && xmlParser.getName().contentEquals("template")){
                    logger.log(xmlParser.getName(), "::", String.valueOf(xmlParser.getAttributeCount())).write('i');
                    String name = new String();
                    Integer priority = null;
                    for (int i = 0; i < xmlParser.getAttributeCount(); i++) {
                        switch (xmlParser.getAttributeName(i))
                        {
                            case "name": name = xmlParser.getAttributeValue(i); break;
                            case "priority": priority = Integer.getInteger(xmlParser.getAttributeValue(i)); break;
                        }
                    }
                    if (name != null && name.length() > 0) {
                        if (priority != null) {
                            patterns.add(priority, new Pattern(name, priority, null));
                        }else{
                            patterns.add(new Pattern(name, null, null));
                        }
                    }

                };
                index = xmlParser.next();
            }
        } catch (Exception e) {
            logger.log(e.getMessage()).write('e');
        }
        return patterns;
    };

}
