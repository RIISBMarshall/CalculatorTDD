package com.example.bmarshall.calculatortdd.Controller;

import com.example.bmarshall.calculatortdd.Model.Calculator;

/**
 * Created by bmarshall on 2/22/17.
 */

public class Controller {

    private Calculator calculator;

    public Controller(){
        calculator = new Calculator();
    }

    public void setSelectedMathOperation(String mathOperation){
        calculator.setSelectedMathOperation(mathOperation);
    }

    public Calculator.MathOperation getSelectedMathOperation(){
        return calculator.getSelectedMathOperation();
    }
}
