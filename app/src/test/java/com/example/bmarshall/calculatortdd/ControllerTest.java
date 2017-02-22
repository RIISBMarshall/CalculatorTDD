package com.example.bmarshall.calculatortdd;

import com.example.bmarshall.calculatortdd.Controller.Controller;
import com.example.bmarshall.calculatortdd.Model.Calculator;

import org.junit.Assert;
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
public class ControllerTest {

    private Controller controller;

    @Before
    public void setUp(){
        controller = new Controller();
    }

    @Test
    public void setSelectedMathOperationTest(){
        String mathOperation = "+";
        controller.setSelectedMathOperation(mathOperation);
        Assert.assertEquals("after setting MathOperation with a + the," +
                        " operation should be equal to ADD",
                Calculator.MathOperation.ADD, controller.getSelectedMathOperation());
    }

    @Test
    public void getSelectedMathOperationTest(){
        String mathOperation = "+";
        controller.setSelectedMathOperation(mathOperation);
        Assert.assertEquals("after setting MathOperation with a + the," +
                        " operation should be equal to ADD",
                Calculator.MathOperation.ADD, controller.getSelectedMathOperation());
    }
}
