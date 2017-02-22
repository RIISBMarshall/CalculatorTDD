package com.example.bmarshall.calculatortdd;

import android.widget.Button;
import android.widget.TextView;

import com.example.bmarshall.calculatortdd.View.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.RobolectricGradleTestRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by bmarshall on 2/22/17.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class CalculatorUnitTest {
    private Button numberOneView;
    private Button numberTwoView;
    private TextView screenView;
    private MainActivity mainActivity;

    @Before
    public void setUp(){
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        assertNotNull("Main Activity not setup", mainActivity);
        numberOneView=(Button) mainActivity.findViewById(R.id.one);
        numberTwoView=(Button) mainActivity.findViewById(R.id.two);
        screenView=(TextView) mainActivity.findViewById(R.id.screenTextView);
    }

    //Feature 1: A user can enter the first number
    @Test
    public void firstNumberEntered(){
        numberOneView.callOnClick();
        numberTwoView.callOnClick();
        String numberEntered = Integer.toString(12);
        assertEquals("number entered should equal number on screen", numberEntered, screenView.getText());
    }
}
