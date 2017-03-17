package ru.loyol.calculator.calculator;

import java.io.Serializable;

/**
 * Created by Andrew on 06.03.2017.
 */

public enum ButtonView implements Serializable {
    vNormal("Normal"),
    vHorizontal("Horizontal"),
    vHorizontalLong("HorizontalLong"),
    vVertical("Vertical"),
    vVerticalLong("VerticalLong");

    private String value;
    public String getValue() { return this.value; }

    ButtonView(String value){
        this.value = value;
    }

    public static ButtonView getNext(ButtonView prev){
        switch (prev) {
            case vNormal: return vHorizontal;
            case vHorizontal: return vHorizontalLong;
            case vHorizontalLong: return vVertical;
            case vVertical: return vVerticalLong;
            default: return vNormal;
        }
    }
}
