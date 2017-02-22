package com.example.bmarshall.calculatortdd.Model;

/**
 * Created by bmarshall on 2/22/17.
 */

public class Calculator {

    public enum MathOperation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY
    }

    private MathOperation selectedMathOperation;

    public Calculator(){

    }

    //Feature 2: A user can can select a math operation(+,-,*,/)
    public void setSelectedMathOperation(String mathOperation){

    }

    //Feature 2: A user can can select a math operation(+,-,*,/)
    public MathOperation getSelectedMathOperation(){
        return selectedMathOperation;
    }
}
