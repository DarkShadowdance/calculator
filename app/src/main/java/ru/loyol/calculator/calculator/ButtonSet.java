package ru.loyol.calculator.calculator;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

/**
 * Created by Andrew on 06.03.2017.
 */

public class ButtonSet extends AppCompatButton {
    private ButtonView buttonView;

    public ButtonSet(Context context) {
        super(context);
        setButtonView();
    }

    public ButtonView getButtonView(){
        return this.buttonView;
    }
    public void setButtonView(){
        this.buttonView = ButtonView.getNext(this.buttonView);
    }
}
