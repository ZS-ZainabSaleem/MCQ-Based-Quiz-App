package com.example.mcqquizapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView tvUserName, tvScore;
    Button btnShareScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        init();

        // Get data from intent
        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        int score = intent.getIntExtra("SCORE", 0);
        int totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 10);

        tvUserName.setText(userName);
        tvScore.setText(score + "/" + totalQuestions);

        btnShareScore.setOnClickListener(v -> {
            String shareMessage = userName + " scored " + score + "/" + totalQuestions + " in the Quiz!";
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "Share your score"));
        });

    }
    private void init()
    {
        tvUserName=findViewById(R.id.tvUserName);
        tvScore=findViewById(R.id.tvScore);
        btnShareScore=findViewById(R.id.btnShareScore);
    }
}