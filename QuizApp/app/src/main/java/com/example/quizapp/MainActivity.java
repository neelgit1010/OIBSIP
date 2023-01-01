package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView questAttempted, quest;
    Button option1,option2,option3,option4, skip;
    ArrayList<Questions> questList;
    int score = 0, attempted = 0, currPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quest = findViewById(R.id.questions);
        questAttempted =  findViewById(R.id.questionsAttempted);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        skip = findViewById(R.id.skipped);
        questList = new ArrayList<Questions>();

        getQuestion(questList);
        currPos = 0;
        setContent(currPos);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (questList.get(currPos).getAnswer().equals(option1.getText().toString())) {
                    score++;
                }
                attempted++;
                currPos++;
                setContent(currPos);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questList.get(currPos).getAnswer().equals(option2.getText().toString())) {
                    score++;
                }
                attempted++;
                currPos++;
                setContent(currPos);

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questList.get(currPos).getAnswer().equals(option3.getText().toString())) {
                    score++;
                }
                attempted++;
                currPos++;
                setContent(currPos);

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questList.get(currPos).getAnswer().equals(option4.getText().toString())) {
                    score++;
                }
                attempted++;
                currPos++;
                setContent(currPos);

            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skipToNext();
            }
        });
    }

    private void showScore(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.show_score,(LinearLayout)findViewById(R.id.result));
        TextView ans = view.findViewById(R.id.ans);
        Button restart = view.findViewById(R.id.restart);

        if(score >= 3)
            ans.setText(String.format("Congrats!\nYou Scored : %d", score));
        else
            ans.setText(String.format("Whoops! Try Again\nYou Scored : %d", score));

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currPos = 0;
                score = 0;
                attempted = 0;
                setContent(currPos);
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }

    private void skipToNext(){
        currPos++;
        setContent(currPos);
    }

    private void setContent(int currPos){

        if (currPos != questList.size()) {
            questAttempted.setText("Questions Attempted : " + attempted + "/5");
            quest.setText(questList.get(currPos).getQuestion());
            option1.setText(questList.get(currPos).getOption1());
            option2.setText(questList.get(currPos).getOption2());
            option3.setText(questList.get(currPos).getOption3());
            option4.setText(questList.get(currPos).getOption4());
        } else {
            questAttempted.setText("Questions Attempted : " + attempted + "/5");
            showScore();
        }
    }

    private void getQuestion(ArrayList<Questions> questList) {
        questList.add(new Questions("Automatic type conversion is possible in which of the possible cases?","Byte to Int", "Int to Long","Long to Int", "Short to Int","Long to Int"));
        questList.add(new Questions("What is the size of float and double in java?","32 and 64", "64 and 32","16 and 64", "32 and 16","32 and 64"));
        questList.add(new Questions("Number of primitive data types in Java are?","4", "10","8", "7","8"));
        questList.add(new Questions("When an array is passed to a method, what does the method receive?","Reference of the Array", "Copy of the Array","Length of the array", "Copy of first element","Reference of the Array"));
        questList.add(new Questions("Arrays in java are","Primitive Data", "Object","Object Reference", "None","Reference of the Array"));
    }
}