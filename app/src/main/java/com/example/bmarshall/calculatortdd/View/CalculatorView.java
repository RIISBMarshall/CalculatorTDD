package com.example.bmarshall.calculatortdd.View;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.bmarshall.calculatortdd.Controller.Controller;
import com.example.bmarshall.calculatortdd.Model.Calculator;
import com.example.bmarshall.calculatortdd.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CalculatorView extends AppCompatActivity {
    private TextView screen;
    public Controller controller;
    private NumberFormat numberFormat;
    private int color;
    private GridLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_calculator);
        controller = new Controller();
        screen = (TextView) findViewById(R.id.screenTextView);
        numberFormat = new DecimalFormat("##.###");
        color = 0;
        background = (GridLayout) findViewById(R.id.activity_main);
    }

    public void onClickNumber(View v) {
        if (controller.getOperationWasSelected() == true) {
            screen.setText("");
            controller.setOperationWasSelected(false);
        }
        if (screen.getText().equals("0")) {
            screen.setText("");
        }

        Button numberButton = (Button) findViewById(v.getId());
        String numberClicked = (String) numberButton.getText();
        String screenNumber = (String) screen.getText();
        screenNumber = screenNumber + numberClicked;
        screen.setText(screenNumber);
    }

    public void onClickOperation(View v) {
        Button operationButton = (Button) findViewById(v.getId());
        String mathOperation = (String) operationButton.getText();
        controller.setSelectedMathOperation(mathOperation);
        String numberToSave = (String) screen.getText();
        controller.setSavedNumber(Double.parseDouble(numberToSave));
    }

    public void onClickEquals(View v){
        String screenNumber = (String) screen.getText();
        double secondNumber = Double.parseDouble(screenNumber);
        Calculator.MathOperation mathOperation = controller.getSelectedMathOperation();
        switch (mathOperation) {
            case ADD:
                controller.add(secondNumber);
                break;
            case SUBTRACT:
                controller.subtract(secondNumber);
                break;
            case MULTIPLY:
                controller.multiply(secondNumber);
                break;
            case DIVIDE:
                controller.divide(secondNumber);
                break;
        }
        String formattedSavedNumber = numberFormat.format(controller.getSavedNumber());
        screen.setText(formattedSavedNumber);
        }

    public void onClickClear(View v){
        controller.setSavedNumber(0);
        screen.setText("0");
    }

    public void onClickChangeBackground(View view) {
        color = color + 1;

        switch (color % 5) {
            case 0:
                background.setBackgroundColor(Color.WHITE);
                break;
            case 1:
                background.setBackgroundColor(Color.BLUE);
                screen.setTextColor(Color.RED);
                break;
            case 2:
                background.setBackgroundColor(Color.RED);
                screen.setTextColor(Color.BLACK);
                break;
            case 3:
                background.setBackgroundColor(Color.YELLOW);
                break;
            case 4:
                background.setBackgroundColor(Color.GREEN);
                break;
        }
    }
    }
