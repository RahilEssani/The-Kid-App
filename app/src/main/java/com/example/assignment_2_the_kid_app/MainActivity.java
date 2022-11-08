package com.example.assignment_2_the_kid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String [] questions= {"Click a box having a unique color.","Click a box having a number", "Click a " +
            "box having red color", "Click a box having a digit 2", "Click a box with the red color having a " +
            "digit 3", "Click a box having a unique digit","Click a box that contains a digit and an alphabet"};
    String[][] actions = {{"red","yellow","green"}};
    TextView question,counter,result;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,winbtn;
    Random rnd = new Random();
    int prev = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.question);
        question.setOnClickListener(this);
        question.setText("Press any button to start...");
    }

    @Override
    public void onClick(View view) {
        System.out.println(view.getId());
        switch (view.getId())
        {
            case R.id.button:
                break;
            case R.id.button10:
                break;
            case R.id.button11:
                break;
            case R.id.button12:
                break;
            case R.id.button13:
                break;
            case R.id.button14:
                break;
            case R.id.button15:
                break;
            case R.id.button16:
                break;
            case R.id.button17: {
                if(winbtn == findViewById(R.id.button17)) {
                    result = findViewById(R.id.textView2);
                    result.setText("Correct!");
                    result.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                }
            }
            default:
                break;
        }
        SetRandomQuestion();
    }
    private void SetRandomQuestion(){
        int index = rnd.nextInt(questions.length);
        while(index == prev){
            index = rnd.nextInt(questions.length);
        }
        question.setText(questions[index]);
        prev = index;
        SetGameEnvironment(index);
    }
    private void SetGameEnvironment(int index){
        switch (index){
            case 0: {
                findViewById(R.id.button).setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.button10).setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.button11).setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.button12).setBackgroundColor(getResources().getColor(R.color.black));
                findViewById(R.id.button13).setBackgroundColor(getResources().getColor(R.color.black));
                findViewById(R.id.button14).setBackgroundColor(getResources().getColor(R.color.black));
                findViewById(R.id.button15).setBackgroundColor(getResources().getColor(R.color.green));
                findViewById(R.id.button16).setBackgroundColor(getResources().getColor(R.color.green));
                findViewById(R.id.button17).setBackgroundColor(getResources().getColor(R.color.blue));
                winbtn = findViewById(R.id.button17);
                break;
            }
            default:
                break;
        }
    }
}