package com.example.bmarshall.calculatortdd.Model;

/**
 * Created by bmarshall on 2/22/17.
 */

public class Calculator {

    public enum MathOperation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY
    }

    private MathOperation selectedMathOperation;

    private boolean operationWasSelected;

    private double savedNumber;

    public Calculator() {
        operationWasSelected = false;
        savedNumber = 0;
    }

    public void setSelectedMathOperation(String mathOperation) {
        switch (mathOperation) {
            case "+":
                selectedMathOperation = MathOperation.ADD;
                break;
            case "-":
                selectedMathOperation = MathOperation.SUBTRACT;
                break;
            case "/":
                selectedMathOperation = MathOperation.DIVIDE;
                break;
            case "X":
                selectedMathOperation = MathOperation.MULTIPLY;
                break;
        }
        operationWasSelected = true;
    }

    public MathOperation getSelectedMathOperation() {
        return selectedMathOperation;
    }

    public boolean getOperationWasSelected() {
        return operationWasSelected;
    }

    public double getSavedNumber() {
        return savedNumber;
    }

    public void setSelectedMathOperation(MathOperation selectedMathOperation) {
        this.selectedMathOperation = selectedMathOperation;
    }

    public void setOperationWasSelected(boolean operationWasSelected) {
        this.operationWasSelected = operationWasSelected;
    }

    public void setSavedNumber(double savedNumber) {
        this.savedNumber = savedNumber;
    }
}
