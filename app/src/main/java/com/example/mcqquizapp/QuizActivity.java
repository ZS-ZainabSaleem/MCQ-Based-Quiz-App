package com.example.mcqquizapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    //hooks
    TextView tvQuizNo,tvQuizBox;
    RadioGroup radioGroup;
    RadioButton rbOption1,rbOption2,rbOption3, rbOption4;
    Button btnPrevious,btnNext;
    private List<QuizModel> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int selectedAnswerIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

        init();
        String name = getIntent().getStringExtra("USER_NAME");
        //load Questions
        questions=QuizData.getQuestions();
        loadQuestions();

        radioGroup.setOnCheckedChangeListener((group,checkedId)->{
            selectedAnswerIndex = group.indexOfChild(findViewById(checkedId));
            if (selectedAnswerIndex != -1) {
                group.getChildAt(selectedAnswerIndex).setBackgroundResource(R.drawable.custom_radiobutton);
            }
        });
        btnNext.setOnClickListener((view)->{
            if (selectedAnswerIndex == -1) {
                // Show a warning message if no option is selected
                Toast.makeText(QuizActivity.this, "Please select an option!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedAnswerIndex == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                score++;
            }
            if (currentQuestionIndex < questions.size() - 1) {
                currentQuestionIndex++;
                loadQuestions();
            }
            else {
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("USER_NAME", name);
                intent.putExtra("SCORE", score);
                intent.putExtra("TOTAL_QUESTIONS", questions.size());
                startActivity(intent);
                finish();
            }
        });
        btnPrevious.setOnClickListener(view -> {
            if (currentQuestionIndex > 0) {
                currentQuestionIndex--;
                loadQuestions();
            }
        });
    }
    private void init()
    {
        tvQuizNo=findViewById(R.id.tvQuizNo);
        tvQuizBox=findViewById(R.id.tvQuizBox);
        radioGroup=findViewById(R.id.radioGroup);
        rbOption1=findViewById(R.id.rbOption1);
        rbOption2=findViewById(R.id.rbOption2);
        rbOption3=findViewById(R.id.rbOption3);
        rbOption4=findViewById(R.id.rbOption4);
        btnPrevious=findViewById(R.id.btnPrevious);
        btnNext=findViewById(R.id.btnNext);
    }
    private void loadQuestions()
    {
        QuizModel currentQuestion= questions.get(currentQuestionIndex);
        //show question on screen
        tvQuizBox.setText(currentQuestion.getQuestionText());
        rbOption1.setText(currentQuestion.getOptions().get(0));
        rbOption2.setText(currentQuestion.getOptions().get(1));
        rbOption3.setText(currentQuestion.getOptions().get(2));
        rbOption4.setText(currentQuestion.getOptions().get(3));
        radioGroup.clearCheck();
        //update pge number
        tvQuizNo.setText((currentQuestionIndex + 1) + "/" + questions.size());

        if (currentQuestionIndex == questions.size() - 1) {
            btnNext.setText("Finish");
        } else {
            btnNext.setText("Next");
        }
        // Disable "Previous" button on first question
        btnPrevious.setEnabled(currentQuestionIndex > 0);

    }
}