package com.example.bmarshall.calculatortdd;

import android.widget.Button;
import android.widget.TextView;

import com.example.bmarshall.calculatortdd.Model.Calculator;
import com.example.bmarshall.calculatortdd.View.CalculatorView;

import junit.framework.Assert;

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
    private Button numberOneView;
    private Button numberTwoView;
    private Button numberThreeView;
    private Button numberFourView;
    private Button numberFiveView;
    private Button numberSixView;
    private Button numberSevenView;
    private Button numberEightView;
    private Button numberNineView;
    private Button addView;
    private Button divideView;
    private Button subtractView;
    private Button multiplyView;
    private TextView screenView;
    private CalculatorView calculatorView;

    @Before
    public void setUp() {
        calculatorView = Robolectric.buildActivity(CalculatorView.class).create().get();
        assertNotNull("Main Activity not setup", calculatorView);
        numberOneView = (Button) calculatorView.findViewById(R.id.one);
        numberTwoView = (Button) calculatorView.findViewById(R.id.two);
        numberThreeView = (Button) calculatorView.findViewById(R.id.three);
        numberFourView = (Button) calculatorView.findViewById(R.id.four);
        numberFiveView = (Button) calculatorView.findViewById(R.id.five);
        numberSixView = (Button) calculatorView.findViewById(R.id.six);
        numberSevenView = (Button) calculatorView.findViewById(R.id.seven);
        numberEightView = (Button) calculatorView.findViewById(R.id.eight);
        numberNineView = (Button) calculatorView.findViewById(R.id.nine);
        addView = (Button) calculatorView.findViewById(R.id.add);
        subtractView = (Button) calculatorView.findViewById(R.id.subtract);
        divideView = (Button) calculatorView.findViewById(R.id.divide);
        multiplyView = (Button) calculatorView.findViewById(R.id.multiply);
        screenView = (TextView) calculatorView.findViewById(R.id.screenTextView);
    }

    //Feature 1: A user can enter the first number
    @Test
    public void firstNumberEntered() {
        numberOneView.callOnClick();
        numberTwoView.callOnClick();
        numberThreeView.callOnClick();
        numberFourView.callOnClick();
        numberFiveView.callOnClick();
        numberSixView.callOnClick();
        numberSevenView.callOnClick();
        numberEightView.callOnClick();
        numberNineView.callOnClick();
        String numberEntered = Integer.toString(123456789);
        assertEquals("number entered should equal number on screen", numberEntered, screenView.getText());
    }

    @Test
    public void secondNumberEntered(){
        numberThreeView.callOnClick();
        numberFourView.callOnClick();
        addView.callOnClick();
        Boolean isTrue = true;
        Assert.assertEquals("The operationWasSelected Boolean should be set to true in order for " +
                "the second number to be entered",
                isTrue, calculatorView.controller.getOperationWasSelected());
        String savedNumberAsString = Double.toString(calculatorView.controller.getSavedNumber());
        assertEquals("saved number should be equal to the number on screen before " +
                "entering the second number", savedNumberAsString, screenView.getText());

        numberOneView.callOnClick();
        numberTwoView.callOnClick();

        String numberEntered = Integer.toString(12);
        assertEquals("number entered should equal number on screen", numberEntered, screenView.getText());
    }

    @Test
    public void operationButtonClicked() {
        addView.callOnClick();
        Assert.assertEquals("after setting MathOperation with a + the," +
                        " operation should be equal to ADD",
                Calculator.MathOperation.ADD, calculatorView.controller.getSelectedMathOperation());

        subtractView.callOnClick();
        Assert.assertEquals("after setting MathOperation with a - the," +
                        " operation should be equal to SUBTRACT",
                Calculator.MathOperation.SUBTRACT, calculatorView.controller.getSelectedMathOperation());

        divideView.callOnClick();
        Assert.assertEquals("after setting MathOperation with a / the," +
                        " operation should be equal to DIVIDE",
                Calculator.MathOperation.DIVIDE, calculatorView.controller.getSelectedMathOperation());

        multiplyView.callOnClick();
        Assert.assertEquals("after setting MathOperation with a X the," +
                        " operation should be equal to MULTIPLY",
                Calculator.MathOperation.MULTIPLY, calculatorView.controller.getSelectedMathOperation());
    }
}
