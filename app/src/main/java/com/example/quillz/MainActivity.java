package com.example.quillz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions = {"James Gosling invented Java Programming?", ".java is the extension " +
            "of java code files?", "Is Compilation an OOPs concept in Java?", ".java is the extension" +
            " of compiled java classes?",
            " Object class is a superclass of every class in Java?"};
    private boolean[] answers = {true, true, false, false, true};
    private int score = 0;
    Button yes;
    Button no;

    private int index = 0;
    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.button);
        no = findViewById(R.id.button2);
        question = findViewById(R.id.question);
        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the array is not going out of bounds
                if (index <= questions.length - 1) {
                    // If you have given correct answer
                    if(answers[index]){
                        score++;
                    }
                    // Go to the next question
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }


        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the array is not going out of bounds
                if (index <= questions.length - 1) {
                    //if you have given correct answer
                    if (!answers[index]) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your score is" + score, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Restart  the app and play again", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}



