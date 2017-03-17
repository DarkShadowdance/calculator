package ru.loyol.calculator.calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Logger logger = Logger.init("MyActivity").on();

    public static final String TAG = "MyActivity";
    private TextView mTextMessage;
    private List<Pattern> patterns;

    public void ButtonOneClick(View view){
        mTextMessage.setText("1");
    }

    public void ButtonTwoClick(View view){
        mTextMessage.setText("2");
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mTextMessage.setText(item.getTitle());
            return true;
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        if (patterns == null) {
            patterns = CalculatorInitializer.load(this);
            logger.log(String.valueOf(patterns.size())).write('i');
        }
        onPrepareOptionsMenu(navigation, patterns);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //TODO
    // идентификаторы для пунктов меню
    private static final int startIds = 1000;

    public boolean onPrepareOptionsMenu(BottomNavigationView bottomNavigationView, List<Pattern> patterns)
    {
        if ((patterns == null) || (patterns.size() == 0)) {
            return true;
        }
        logger.log("onPrepareOptionsMenu ", String.valueOf(patterns.size()));
        // добавляем пункты меню (max 5)
        MenuItem item;
        Menu menu = bottomNavigationView.getMenu();
        final int maxCount = bottomNavigationView.getMaxItemCount();
        int index = startIds;

        for (Pattern pattern : patterns) {
            if (menu.size() < maxCount) {
                index += 1;
                logger
                    .log(
                        String.valueOf(menu.size()), "/", String.valueOf(maxCount)
                        , " >> ", String.valueOf(index), " :: ", pattern.getName())
                    .write('i');
                menu.add(Menu.NONE, index, Menu.NONE, pattern.getName());
            }
        }
        return true;
    }
}
