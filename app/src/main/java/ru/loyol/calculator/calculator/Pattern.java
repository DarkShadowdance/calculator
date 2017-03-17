package ru.loyol.calculator.calculator;

import android.renderscript.RenderScript;

import java.util.List;

/**
 * Created by Andrew on 06.03.2017.
 */

public class Pattern {
    private String name;
    private Integer priority;
    private List<ButtonSet> buttons;

    public Pattern(String name, Integer priority, List<ButtonSet> buttons) {
        this.name = name;
        this.priority = priority;
        this.buttons = buttons;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    public List<ButtonSet> getButtons() {
        return buttons;
    }
}
