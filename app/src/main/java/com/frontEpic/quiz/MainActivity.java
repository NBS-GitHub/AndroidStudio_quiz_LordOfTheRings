package com.frontEpic.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton frontEpicBtn;
    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton previousButton;
    private TextView questionTextView;

    private int currentQuestionIndex = 0;

    private List<Question> questionBank = new LinkedList<>();
    private Object[][] quizData = QuizData.getDataArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (Object[] quizData : quizData) {
            String questionText = (String) quizData[0];
            boolean correctAnswer = (Boolean) quizData[1];
            questionBank.add(new Question(questionText, correctAnswer));
        }

        frontEpicBtn = findViewById(R.id.frontEpicImageButton);
        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        questionTextView = findViewById(R.id.questionTextView);
        previousButton = findViewById(R.id.previous_button);
        nextButton = findViewById(R.id.next_button);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.true_button:
                checkAnswer(true);
                break;
            case R.id.false_button:
                checkAnswer(false);
                break;
            case R.id.previous_button:
                currentQuestionIndex = (currentQuestionIndex - 1) <0 ? questionBank.size() - 1 : currentQuestionIndex - 1;
                updateQuestion();
                break;
            case R.id.next_button:
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.size();
                updateQuestion();
                break;
        }
    }

    private void updateQuestion(){
        questionTextView.setText(questionBank.get(currentQuestionIndex).getquestionText());

    }

    private void checkAnswer(boolean usersChoice) {
        boolean correctAnswer = questionBank.get(currentQuestionIndex).getCorrectAnswer();
        int toastMessageId = 0;

        if(usersChoice == correctAnswer) {
            toastMessageId = R.string.correct_answer;
        } else {
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(MainActivity.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }

    public void goToFrontEpic(View view) {
        Uri address = Uri.parse("https://www.frontepic.com");
        Intent goToFrontEpic = new Intent(Intent.ACTION_VIEW, address);
        if(goToFrontEpic.resolveActivity(getPackageManager()) != null)
            startActivity(goToFrontEpic);
    }

}
