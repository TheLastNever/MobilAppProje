package com.example.colorchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    RadioButton red, blue, green;
    ConstraintLayout constraintLayout;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        constraintLayout = (ConstraintLayout) findViewById(R.id.ConstraintLayouts);
        green = (RadioButton) findViewById(R.id.radioButton5);
        blue = (RadioButton) findViewById(R.id.radioButton6);
        red = (RadioButton) findViewById(R.id.radioButton4);


    }

    public void openNewActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void ChangeColorRed(View view)
    {
        constraintLayout.setBackgroundColor(Color.RED);
        green.setChecked(false);
        blue.setChecked(false);

    }

    public void ChangeColorBlue(View view)
    {
        constraintLayout.setBackgroundColor(Color.BLUE);
        green.setChecked(false);
        red.setChecked(false);
    }

    public void ChangeColorGreen(View view)
    {
        constraintLayout.setBackgroundColor(Color.GREEN);
        red.setChecked(false);
        blue.setChecked(false);

    }

}