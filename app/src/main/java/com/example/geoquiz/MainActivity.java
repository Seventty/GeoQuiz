package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mBackButton;
    private TextView mQuestionTextView;

   private TrueFalse[] mQuestionBank = new TrueFalse[]{
           new TrueFalse(R.string.question_primer_presidente, true),
           new TrueFalse(R.string.question_alunizaje, true),
           new TrueFalse(R.string.question_primera_guerra, false),
           new TrueFalse(R.string.question_koalas, false),
           new TrueFalse(R.string.question_flor, true),
           new TrueFalse(R.string.question_oxigeno, false),
           new TrueFalse(R.string.question_guerra_de_100_años, false),
           new TrueFalse(R.string.question_conejos, false),
           new TrueFalse(R.string.question_alunizaje, true),
           new TrueFalse(R.string.question_peso_termitas, true),
           new TrueFalse(R.string.question_orangutanes, false),

    };
   private int mCurrentIndex = 0;
   private void updateQuestion(){
       int question = mQuestionBank[mCurrentIndex].getQuestion();
       mQuestionTextView.setText(question);
   }
   private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue){
            messageResId = R.string.Correct_Toast;
        }
        else{
            messageResId = R.string.Incorrect_Toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionTextView = (TextView)findViewById(R.id.Questionario);
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
        mTrueButton = (Button)findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            checkAnswer(true);
            }
        });
        mQuestionTextView = (TextView)findViewById(R.id.Questionario);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1)%mQuestionBank.length;
                updateQuestion();
            }
        });

        mFalseButton = (Button)findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });


        mNextButton = (Button)findViewById(R.id.NextButton);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mBackButton = (Button)findViewById(R.id.BackButton);
        mBackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex-1)%mQuestionBank.length;
                updateQuestion();
            }
        });

    updateQuestion();
    }
}
