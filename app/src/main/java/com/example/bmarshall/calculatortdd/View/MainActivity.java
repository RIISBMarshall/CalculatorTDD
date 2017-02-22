package com.example.bmarshall.calculatortdd.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bmarshall.Controller.Controller;
import com.example.bmarshall.calculatortdd.R;

public class MainActivity extends AppCompatActivity {
    private TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Controller controller = new Controller();
        screen = (TextView) findViewById(R.id.screenTextView);
    }

    public void onClickNumber(View v){
        Button numberButton = (Button) findViewById(v.getId());
        String numberClicked = (String) numberButton.getText();
        String screenNumber = (String) screen.getText();
        screenNumber = screenNumber + numberClicked;
        screen.setText(screenNumber);
    }
}
