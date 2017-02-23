package com.example.bmarshall.calculatortdd;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.bmarshall.calculatortdd.Model.Calculator;
import com.example.bmarshall.calculatortdd.View.CalculatorView;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.RobolectricGradleTestRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by bmarshall on 2/22/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class CalculatorViewTest {
    private Button numberOneButton;
    private Button numberTwoButton;
    private Button numberThreeButton;
    private Button numberFourButton;
    private Button numberFiveButton;
    private Button numberSixButton;
    private Button numberSevenButton;
    private Button numberEightButton;
    private Button numberNineButton;
    private Button addButton;
    private Button divideButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button equalsButton;
    private Button changeBackground;
    private TextView screenView;
    private Button clearButton;
    private CalculatorView calculatorView;

    @Before
    public void setUp() {
        calculatorView = Robolectric.buildActivity(CalculatorView.class).create().get();
        assertNotNull("Main Activity not setup", calculatorView);
        numberOneButton = (Button) calculatorView.findViewById(R.id.one);
        numberTwoButton = (Button) calculatorView.findViewById(R.id.two);
        numberThreeButton = (Button) calculatorView.findViewById(R.id.three);
        numberFourButton = (Button) calculatorView.findViewById(R.id.four);
        numberFiveButton = (Button) calculatorView.findViewById(R.id.five);
        numberSixButton = (Button) calculatorView.findViewById(R.id.six);
        numberSevenButton = (Button) calculatorView.findViewById(R.id.seven);
        numberEightButton = (Button) calculatorView.findViewById(R.id.eight);
        numberNineButton = (Button) calculatorView.findViewById(R.id.nine);
        addButton = (Button) calculatorView.findViewById(R.id.add);
        subtractButton = (Button) calculatorView.findViewById(R.id.subtract);
        divideButton = (Button) calculatorView.findViewById(R.id.divide);
        multiplyButton = (Button) calculatorView.findViewById(R.id.multiply);
        equalsButton = (Button) calculatorView.findViewById(R.id.equals);
        clearButton = (Button) calculatorView.findViewById(R.id.clearButton);
        changeBackground = (Button) calculatorView.findViewById(R.id.changeBackground);
        screenView = (TextView) calculatorView.findViewById(R.id.screenTextView);
    }

    @Test
    public void firstNumberEnteredTest() {
        numberOneButton.callOnClick();
        numberTwoButton.callOnClick();
        numberThreeButton.callOnClick();
        numberFourButton.callOnClick();
        numberFiveButton.callOnClick();
        numberSixButton.callOnClick();
        numberSevenButton.callOnClick();
        numberEightButton.callOnClick();
        numberNineButton.callOnClick();
        String numberEntered = Integer.toString(123456789);
        assertEquals("number entered should equal number on screen", numberEntered, screenView.getText());
    }

    @Test
    public void secondNumberEnteredTest() {
        numberThreeButton.callOnClick();
        numberFourButton.callOnClick();
        addButton.callOnClick();
        Assert.assertEquals("The operationWasSelected Boolean should be set to true in order for " +
                        "the second number to be entered",
                true, calculatorView.controller.getOperationWasSelected());
        String savedNumberAsString = Integer.toString((int) calculatorView.controller.getSavedNumber());
        assertEquals("saved number should be equal to the number on screen before " +
                "entering the second number", screenView.getText(), savedNumberAsString);

        numberOneButton.callOnClick();
        numberTwoButton.callOnClick();

        String numberEntered = Integer.toString(12);
        assertEquals("number entered should equal number on screen", numberEntered, screenView.getText());
    }

    @Test
    public void onClickOperationTest() {
        addButton.callOnClick();
        Assert.assertEquals("after setting MathOperation with a + the," +
                        " operation should be equal to ADD",
                Calculator.MathOperation.ADD, calculatorView.controller.getSelectedMathOperation());

        subtractButton.callOnClick();
        Assert.assertEquals("after setting MathOperation with a - the," +
                        " operation should be equal to SUBTRACT",
                Calculator.MathOperation.SUBTRACT, calculatorView.controller.getSelectedMathOperation());

        divideButton.callOnClick();
        Assert.assertEquals("after setting MathOperation with a / the," +
                        " operation should be equal to DIVIDE",
                Calculator.MathOperation.DIVIDE, calculatorView.controller.getSelectedMathOperation());

        multiplyButton.callOnClick();
        Assert.assertEquals("after setting MathOperation with a X the," +
                        " operation should be equal to MULTIPLY",
                Calculator.MathOperation.MULTIPLY, calculatorView.controller.getSelectedMathOperation());
    }

    @Test
    public void onClickEqualsTest() {
        numberOneButton.callOnClick();
        numberFiveButton.callOnClick();
        addButton.callOnClick();
        numberFourButton.callOnClick();
        equalsButton.callOnClick();
        assertEquals("savedNumber should be set to equation result",
                19, calculatorView.controller.getSavedNumber(), 0);
        assertEquals("screen should be set to first number + second number",
                "19", screenView.getText());

        screenView.setText("");

        numberOneButton.callOnClick();
        numberFiveButton.callOnClick();
        subtractButton.callOnClick();
        numberFourButton.callOnClick();
        equalsButton.callOnClick();
        assertEquals("savedNumber should be set to equation result",
                11, calculatorView.controller.getSavedNumber(), 0);
        assertEquals("screen should be set to first number + second number",
                "11", screenView.getText());

        screenView.setText("");

        numberOneButton.callOnClick();
        numberFiveButton.callOnClick();
        multiplyButton.callOnClick();
        numberFourButton.callOnClick();
        equalsButton.callOnClick();
        assertEquals("savedNumber should be set to equation result",
                60, calculatorView.controller.getSavedNumber(), 0);
        assertEquals("screen should be set to first number + second number",
                "60", screenView.getText());

        screenView.setText("");

        numberOneButton.callOnClick();
        numberFiveButton.callOnClick();
        divideButton.callOnClick();
        numberThreeButton.callOnClick();
        equalsButton.callOnClick();
        assertEquals("savedNumber should be set to equation result",
                5, calculatorView.controller.getSavedNumber(), 0);
        assertEquals("screen should be set to first number + second number",
                "5", screenView.getText());
    }

    @Test
    public void onClickClearTest() {
        numberOneButton.callOnClick();
        clearButton.callOnClick();
        assertEquals("screen should be set to 0 after clear", "0", screenView.getText());
        assertEquals("saved number should be set to 0", 0.0, calculatorView.controller.getSavedNumber(), 0);
    }

    @Test
    public void onClickChangeBackgroundTest() {
        changeBackground.callOnClick();
        GridLayout background = (GridLayout) calculatorView.findViewById(R.id.activity_main);
        ColorDrawable backgroundColor = (ColorDrawable) background.getBackground();
        assertEquals("currentColor should be blue", Color.BLUE, backgroundColor.getColor());
        changeBackground.callOnClick();
        backgroundColor = (ColorDrawable) background.getBackground();
        assertEquals("currentColor should be red", Color.RED, backgroundColor.getColor());
        changeBackground.callOnClick();
        backgroundColor = (ColorDrawable) background.getBackground();
        assertEquals("currentColor should be yellow", Color.YELLOW, backgroundColor.getColor());
        changeBackground.callOnClick();
        backgroundColor = (ColorDrawable) background.getBackground();
        assertEquals("currentColor should be green", Color.GREEN, backgroundColor.getColor());
        changeBackground.callOnClick();
        backgroundColor = (ColorDrawable) background.getBackground();
        assertEquals("currentColor should be white", Color.WHITE, backgroundColor.getColor());
    }

    @After
    public void tearDown() {
        numberOneButton = null;
        numberTwoButton = null;
        numberThreeButton = null;
        numberFourButton = null;
        numberFiveButton = null;
        numberSixButton = null;
        numberSevenButton = null;
        numberEightButton = null;
        numberNineButton = null;
        addButton = null;
        divideButton = null;
        subtractButton = null;
        multiplyButton = null;
        screenView = null;
        calculatorView = null;
    }
}
