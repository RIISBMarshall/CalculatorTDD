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
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void mathOperationSet() {
        calculator.setSelectedMathOperation("+");

        Assert.assertEquals("after setting MathOperation with a + the," +
                        " operation should be equal to ADD",
                Calculator.MathOperation.ADD, calculator.getSelectedMathOperation());

        calculator.setSelectedMathOperation("-");

        Assert.assertEquals("after setting MathOperation with a - the," +
                        " operation should be equal to SUBTRACT",
                Calculator.MathOperation.SUBTRACT, calculator.getSelectedMathOperation());

        calculator.setSelectedMathOperation("/");

        Assert.assertEquals("after setting MathOperation with a / the," +
                        " operation should be equal to DIVIDE",
                Calculator.MathOperation.DIVIDE, calculator.getSelectedMathOperation());

        calculator.setSelectedMathOperation("X");

        Assert.assertEquals("after setting MathOperation with a X the," +
                        " operation should be equal to ADD",
                Calculator.MathOperation.MULTIPLY, calculator.getSelectedMathOperation());
    }

    @Test
    public void getSelectedMathOperationTest() {
        calculator.setSelectedMathOperation(Calculator.MathOperation.ADD);
        Assert.assertEquals(Calculator.MathOperation.ADD, calculator.getSelectedMathOperation());
    }

    @Test
    public void getOperationWasSelectedTest(){
        calculator.setOperationWasSelected(true);
        Assert.assertEquals(true, calculator.getOperationWasSelected());
    }

    @Test
    public void getSavedNumberTest() {
        double numberToSave = 23.8;
        calculator.setSavedNumber(numberToSave);
        Assert.assertEquals(numberToSave, calculator.getSavedNumber());
    }

    @Test
    public void setSelectedMathOperationTest() {
        calculator.setSelectedMathOperation(Calculator.MathOperation.ADD);
        Assert.assertEquals(Calculator.MathOperation.ADD, calculator.getSelectedMathOperation());
    }

    @Test
    public void setOperationWasSelectedTest() {
        calculator.setOperationWasSelected(true);
        Assert.assertEquals(true, calculator.getOperationWasSelected());
    }

    @Test
    public void setSavedNumberTest() {
        Double numberToSave = 23.8;
        calculator.setSavedNumber(numberToSave);
        Assert.assertEquals(numberToSave, calculator.getSavedNumber());
    }

    @Test
    public void addTest(){
        calculator.setSavedNumber(5);
        calculator.add(5);
        Assert.assertEquals("saved number should be 10", 10.0, calculator.getSavedNumber());
    }

    @Test
    public void subtractTest(){
        calculator.setSavedNumber(5);
        calculator.subtract(2);
        org.junit.Assert.assertEquals("saved number should equal 3", 3.0, calculator.getSavedNumber(), 0);
    }

    @Test
    public void multiplyTest(){
        calculator.setSavedNumber(5);
        calculator.multiply(5);
        org.junit.Assert.assertEquals("saved number should equal 25", 25.0, calculator.getSavedNumber(), 0);
    }

    @Test
    public void divideTest(){
        calculator.setSavedNumber(15);
        calculator.divide(3);
        org.junit.Assert.assertEquals("saved number should equal 5", 5.0, calculator.getSavedNumber(), 0);
    }
}
