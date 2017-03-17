package ru.loyol.calculator.calculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

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
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.calc:
                    mTextMessage.setText(R.string.calculator);
                    return true;
                case i:
                    mTextMessage.setText("IDM_OPEN");
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        onPrepareOptionsMenu(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //TODO
    // идентификаторы для пунктов меню
    private static final int i = 101;

    public boolean onPrepareOptionsMenu(BottomNavigationView bottomNavigationView)
    {
        MenuItem item;
        Menu menu = bottomNavigationView.getMenu();
        // добавляем пункты меню (max 5)
        if (bottomNavigationView.getMaxItemCount() > bottomNavigationView.getChildCount() + 1) {
            menu.add(Menu.NONE, i, Menu.NONE, "Открыть");
        }
        return true;
    }
}
