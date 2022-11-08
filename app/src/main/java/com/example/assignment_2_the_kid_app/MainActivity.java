package com.example.assignment_2_the_kid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String [] questions= {"Click a box having a unique color.","Click a box having a number", "Click a " +
            "box having red color", "Click a box having a digit 2", "Click a box with the red color having a " +
            "digit 3", "Click a box having a unique digit","Click a box that contains a digit and an alphabet"};
    TextView question,counter,result;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.question);
        question.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            default:
                break;
        }
    }
}