package com.example.assignment_2_the_kid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String [] questions= {"Click a box having a unique color.","Click a box having a number", "Click a " +
            "box having red color", "Click a box having a digit 2", "Click a box with the yellow color having a " +
            "digit 3", "Click a box having a unique digit","Click a box that contains a digit and an alphabet"};
    String[] actions = {"green","9","red","2","yellow 3", "6", "A3"};

    TextView question,counter,result,right,wrong;
    int wintn,correctAnswer = 0,wrongAnswer = 0;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    ArrayList<Button> arr = new ArrayList<>();
    Random rnd = new Random();
    int prev = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.question);
        question.setOnClickListener(this);
        question.setText("Press any button to start...");
        result = findViewById(R.id.result);
        right = findViewById(R.id.right1);
        wrong = findViewById(R.id.wrong);
        btn1 = findViewById(R.id.button);
        arr.add(btn1);
        btn2 = findViewById(R.id.button10);
        arr.add(btn2);
        btn3 = findViewById(R.id.button11);
        arr.add(btn3);
        btn4 = findViewById(R.id.button12);
        arr.add(btn4);
        btn5 = findViewById(R.id.button13);
        arr.add(btn5);
        btn6 = findViewById(R.id.button14);
        arr.add(btn6);
        btn7 = findViewById(R.id.button15);
        arr.add(btn7);
        btn8 = findViewById(R.id.button16);
        arr.add(btn8);
        btn9 = findViewById(R.id.button17);
        arr.add(btn9);

    }

    @Override
    public void onClick(View view) {
        System.out.println(view.getId());
        switch (view.getId())
        {
            case R.id.button:
                DetermineAnswer(R.id.button);
                break;
            case R.id.button10:
                DetermineAnswer(R.id.button10);
                break;
            case R.id.button11:
                DetermineAnswer(R.id.button11);
                break;
            case R.id.button12:
                DetermineAnswer(R.id.button12);
                break;
            case R.id.button13:
                DetermineAnswer(R.id.button13);
                break;
            case R.id.button14:
                DetermineAnswer(R.id.button14);
                break;
            case R.id.button15:
                DetermineAnswer(R.id.button15);
                break;
            case R.id.button16:
                DetermineAnswer(R.id.button16);
                break;
            case R.id.button17:
                    DetermineAnswer(R.id.button17);
                    break;
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
                String [] color = {"red","blue","green","yellow","orange"};
                int temp = rnd.nextInt(arr.size());
                int temp1 = rnd.nextInt(color.length);
                int prev = -1;
                System.out.println(arr.get(temp).getId());
                System.out.println(color[temp1]);
                SetColor(arr.get(temp),color[temp1]);
                for(Button b : arr){
                    if(b != arr.get(temp)){
                        System.out.println(b.getId());
                        int t = rnd.nextInt(color.length);
                        System.out.println(color[t]);
                        while(t == temp1 || t == prev)
                        {
                            t = rnd.nextInt(color.length);
                        }
                        prev = t;
                        SetColor(b,color[t]);
                    }
                }
                wintn = arr.get(temp).getId();
                break;
            }
            case 1:
            {

                break;
            }
            default:
                break;
        }
    }
    private void DetermineAnswer(int viewID){
        if(wintn == viewID) {
            result.setText("Correct!");
            result.setTextColor((getResources().getColor(R.color.green)));
            correctAnswer++;
            right.setText(String.valueOf(correctAnswer));
            wintn = 0;
        }
        else{
            wintn = 0;
            wrongAnswer++;
            wrong.setText(String.valueOf(wrongAnswer));
        }
    }
    private void SetColor(Button but, String color)
    {
        if(color=="green")
        {
            but.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else if(color=="red")
        {
            but.setBackgroundColor(getResources().getColor(R.color.red));
        }
        else if(color=="blue")
        {
            but.setBackgroundColor(getResources().getColor(R.color.blue));
        }
        else if(color=="orange")
        {
            but.setBackgroundColor(getResources().getColor(R.color.orange));
        }
        else if(color=="yellow")
        {
            but.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
    }
}