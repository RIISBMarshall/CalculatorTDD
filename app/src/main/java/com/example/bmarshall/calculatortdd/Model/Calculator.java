package com.example.bmarshall.calculatortdd.Model;

/**
 * Created by bmarshall on 2/22/17.
 */

public class Calculator {

    public enum MathOperation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY
    }

    private MathOperation selectedMathOperation;

    private Boolean operationWasSelected;

    public Calculator() {

    }

    //Feature 2: A user can can select a math operation(+,-,*,/)
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
    }

    //Feature 2: A user can can select a math operation(+,-,*,/)
    public MathOperation getSelectedMathOperation() {
        return selectedMathOperation;
    }
}
