package com.example.bmarshall.calculatortdd.Controller;

import com.example.bmarshall.calculatortdd.Model.Calculator;

/**
 * Created by bmarshall on 2/22/17.
 */

public class Controller {

    private Calculator calculator;

    public Controller() {
        calculator = new Calculator();
    }

    public void setSelectedMathOperation(String mathOperation) {
        calculator.setSelectedMathOperation(mathOperation);
    }

    public Calculator.MathOperation getSelectedMathOperation() {
        return calculator.getSelectedMathOperation();
    }

    public boolean getOperationWasSelected() {
        return calculator.getOperationWasSelected();
    }

    public double getSavedNumber() {
        return calculator.getSavedNumber();
    }

    public void setOperationWasSelected(boolean operationWasSelected) {
        calculator.setOperationWasSelected(operationWasSelected);
    }

    public void setSavedNumber(double savedNumber) {
        calculator.setSavedNumber(savedNumber);
    }

    public void add(double secondNumber) {
        calculator.add(secondNumber);
    }

    public void subtract(double secondNumber) {
        calculator.subtract(secondNumber);
    }

    public void divide(double secondNumber) {
        calculator.divide(secondNumber);
    }

    public void multiply(double secondNumber) {
        calculator.multiply(secondNumber);
    }
}
