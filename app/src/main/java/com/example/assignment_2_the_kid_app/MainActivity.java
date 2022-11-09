package com.example.assignment_2_the_kid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String [] questions= {"Click a box having a unique color.","Click a box having a number", "Click a " +
            "box having red color", "Click a box having a digit 2", "Click a box with the yellow color having a " +
            "digit 3", "Click a box having a unique digit","Click a box that contains a digit and an alphabet"};
    String[] actions = {"green","9","red","2","yellow 3", "6", "A3"};

    TextView question,result,right,wrong;
    int wintn,correctAnswer = 0,wrongAnswer = 0;
    Boolean game = false;
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
        if(game){
            game = true;
        }
        else {
            switch (view.getId()) {
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
                ArrayList<String> color = new ArrayList<>();
                color.add("red");
                color.add("yellow");
                color.add("orange");
                color.add("green");
                int temp = rnd.nextInt(arr.size());
                int temp1 = rnd.nextInt(color.size());
                int prev = -1;
                SetColor(arr.get(temp),color.get(temp1));
                arr.get(temp).setText(color.get(temp1).toUpperCase());
                color.remove(temp1);
                for(Button b : arr){
                    if(b != arr.get(temp)){
                        int t = rnd.nextInt(color.size());
                        System.out.println(color.get(t));
                        while(t == temp1 || t == prev)
                        {
                            t = rnd.nextInt(color.size());
                        }
                        prev = t;
                        b.setText(color.get(t).toUpperCase());
                        SetColor(b,color.get(t));
                    }
                }
                wintn = arr.get(temp).getId();
                break;
            }
            case 1:
            {
                ArrayList<String> color = new ArrayList<>();
                color.add("blue");
                color.add("white");
                color.add("teal");
                color.add("red");
                color.add("yellow");
                color.add("orange");
                color.add("green");
                int num = rnd.nextInt(200);
                int ind = rnd.nextInt(arr.size());
                arr.get(ind).setText(String.valueOf(num));
                for(Button b: arr)
                {
                    if(b != arr.get(ind)) {
                        int t = rnd.nextInt(color.size());
                        SetColor(b, color.get(t));
                        b.setText(color.get(t).toUpperCase());
                    }
                }
                wintn = arr.get(ind).getId();
                break;
            }
            case 2:
            {
                ArrayList<String> color = new ArrayList<>();
                color.add("blue");
                color.add("white");
                color.add("teal");
                color.add("purple");
                color.add("yellow");
                color.add("orange");
                color.add("green");
                int ind = rnd.nextInt(arr.size());
                SetColor(arr.get(ind),"red");
                arr.get(ind).setText("RED");
                for(Button b : arr){
                    if(b != arr.get(ind)){
                        int t = rnd.nextInt(color.size());
                        b.setText(color.get(t).toUpperCase());
                        SetColor(b,color.get(t));
                    }
                }
                wintn = arr.get(ind).getId();
                break;
            }
            case 3:{
                ArrayList<String> color = new ArrayList<>();
                color.add("A");color.add("B");color.add("Z");color.add("I");color.add("/");color.add("+");
                color.add("%");color.add("G");color.add("K");color.add(">");color.add("{");
                color.add("L");

                int ind = rnd.nextInt(arr.size());
                arr.get(ind).setText("2");
                for(Button b: arr)
                {
                    if(b != arr.get(ind)) {
                        int t = rnd.nextInt(color.size());
                        b.setText(color.get(t));
                    }
                }
                wintn = arr.get(ind).getId();
                break;
            }
            case 4:{
                ArrayList<String> color = new ArrayList<>();
                color.add("blue");color.add("white");color.add("teal");color.add("purple");
                color.add("red");color.add("orange");color.add("green");

                int ind = rnd.nextInt(arr.size());
                arr.get(ind).setText("3");
                SetColor(arr.get(ind),"yellow");
                for(Button b: arr)
                {
                    if(b != arr.get(ind)) {
                        int t = rnd.nextInt(color.size());
                        b.setText(String.valueOf(t));
                        SetColor(b,color.get(t));
                    }
                }
                wintn = arr.get(ind).getId();
                break;
            }
            case 5:{
                ArrayList<String> color = new ArrayList<>();
                color.add("1");color.add("2");color.add("3");

                int ind = rnd.nextInt(arr.size());
                int answer = rnd.nextInt(color.size());
                arr.get(ind).setText(color.get(answer));
                for(Button b: arr)
                {
                    SetColor(b,"purple");
                    if(b != arr.get(ind)) {
                        int t = rnd.nextInt(color.size());
                        while(t == answer){
                            t = rnd.nextInt(color.size());
                        }
                        b.setText(color.get(t));
                    }
                }
                wintn = arr.get(ind).getId();
                break;
            }
            case 6: {
                ArrayList<String> color = new ArrayList<>();
                ArrayList<String> alphabet = new ArrayList<>();
                color.add("1");color.add("2");color.add("3");color.add("4"); color.add("5");
                alphabet.add("O");alphabet.add("L");alphabet.add("K");alphabet.add("V");alphabet.add("C");
                alphabet.add("A");alphabet.add("B");alphabet.add("C");
                int ind = rnd.nextInt(arr.size());
                int answer = rnd.nextInt(color.size());
                int answer2 = rnd.nextInt(alphabet.size());
                arr.get(ind).setText(color.get(answer)+alphabet.get(answer2));
                int rand = 0;
                for(Button b: arr)
                {
                    SetColor(b,"white");
                    if(b != arr.get(ind)) {
                        int t = rnd.nextInt(color.size());
                        int t2 = rnd.nextInt(alphabet.size());
                        while(t == answer || t2 == answer2){
                            t = rnd.nextInt(color.size());
                            t2 = rnd.nextInt(alphabet.size());
                        }
                        if(rand == 0){
                            b.setText(alphabet.get(t2)+color.get(t)+alphabet.get(t2));
                            rand = 1;
                        }
                        else {
                            b.setText(color.get(t)+alphabet.get(t2)+color.get(t));
                            rand = 0;
                        }
                    }
                }
                wintn = arr.get(ind).getId();
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
            result.setText("Wrong!");
            result.setTextColor((getResources().getColor(R.color.red)));
            wintn = 0;
            wrongAnswer++;
            wrong.setText(String.valueOf(wrongAnswer));
        }
    }
    private void SetColor(Button but, String color)
    {
        if(color.contentEquals("green"))
        {
            but.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else if(color.contentEquals("red"))
        {
            but.setBackgroundColor(getResources().getColor(R.color.red));
        }
        else if(color.contentEquals("blue"))
        {
            but.setBackgroundColor(getResources().getColor(R.color.blue));
        }
        else if(color.contentEquals("orange"))
        {
            but.setBackgroundColor(getResources().getColor(R.color.orange));
        }
        else if(color.contentEquals("yellow"))
        {
            but.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else if(color.contentEquals("white"))
        {
            but.setBackgroundColor(getResources().getColor(R.color.white));
        }
        else if(color.contentEquals("purple"))
        {
            but.setBackgroundColor(getResources().getColor(R.color.purple_200));
        }
        else if(color.contentEquals("black"))
        {
            but.setBackgroundColor(getResources().getColor(R.color.black));
        }
        else if(color.contentEquals("teal"))
        {
            but.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }
}