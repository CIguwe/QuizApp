package com.example.chide.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    int correctAnswers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private void questionOneAnswer(){
        RadioButton radioButtonItaly = findViewById(R.id.text_correctAns1);
        boolean isQuestionOneChecked = radioButtonItaly.isChecked();
        if (isQuestionOneChecked){
            correctAnswers += 1;
        }
    }

    private void questionTwoAnswer() {
        EditText userInput = findViewById(R.id.UserInput);
        String name = userInput.getText().toString();
        if (name.trim().equalsIgnoreCase("Neymar")){
            correctAnswers += 1;
        }
    }


    private void questionThreeAnswer(){
        CheckBox questionThreeWeah = findViewById(R.id.text_correctAns2);
        CheckBox questionThreeOwen= findViewById(R.id.text_answerOwen);
        CheckBox questionThreeZidane = findViewById(R.id.text_correctAns3);
        CheckBox questionThreeIbra = findViewById(R.id.text_answerIbra);
        boolean isQuestionThreeWeahChecked = questionThreeWeah.isChecked();
        boolean isQuestionThreeOwenChecked = questionThreeOwen.isChecked();
        boolean isQuestionThreeZidaneChecked = questionThreeZidane.isChecked();
        boolean isQuestionThreeIbraChecked = questionThreeIbra.isChecked();

        if (isQuestionThreeWeahChecked && isQuestionThreeZidaneChecked && !isQuestionThreeIbraChecked && !isQuestionThreeOwenChecked){
            correctAnswers += 1;
        }
    }

    private void questionFourAnswer(){
        RadioButton radioButton20 = (RadioButton) findViewById(R.id.text_correctAns4);
        boolean isQuestionFourChecked = radioButton20.isChecked();
        if (isQuestionFourChecked){
            correctAnswers += 1;
        }
    }

    private void questionFiveAnswer(){
        CheckBox questionFivePepe = findViewById(R.id.text_answerPepe);
        CheckBox questionFiveKroos = findViewById(R.id.text_correctAns5);
        CheckBox questionFiveRonaldo = findViewById(R.id.text_answerRonaldo);
        CheckBox questionFiveCeballos = findViewById(R.id.text_correctAns6);
        boolean isQuestionFivePepeChecked = questionFivePepe.isChecked();
        boolean isQuestionFiveKroosChecked = questionFiveKroos.isChecked();
        boolean isQuestionFiveRonaldoChecked = questionFiveRonaldo.isChecked();
        boolean isQuestionFiveCeballosChecked = questionFiveCeballos.isChecked();

        if (isQuestionFiveCeballosChecked && isQuestionFiveKroosChecked && !isQuestionFiveRonaldoChecked && !isQuestionFivePepeChecked){
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions(){
        questionOneAnswer();
        questionTwoAnswer();
        questionThreeAnswer();
        questionFourAnswer();
        questionFiveAnswer();
    }

    private void resetCounter(){
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View view){
            checkAllQuestions();
            Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers +
                        "/5", Toast.LENGTH_LONG).show();

            resetCounter();
        }
    };
}
