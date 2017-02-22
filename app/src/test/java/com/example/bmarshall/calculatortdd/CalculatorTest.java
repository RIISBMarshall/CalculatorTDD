package com.example.bmarshall.calculatortdd;

import com.example.bmarshall.calculatortdd.Model.Calculator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by bmarshall on 2/22/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void mathOperationSet(){
        calculator.setSelectedMathOperation("+");
        Assert.assertEquals("after setting MathOperation with a + the," +
                " operation should be equal to ADD",
                Calculator.MathOperation.ADD, calculator.getSelectedMathOperation());
    }
}
