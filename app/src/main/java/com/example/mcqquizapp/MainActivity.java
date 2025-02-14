package com.example.mcqquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //hooks
    EditText et_inputName;
    Button start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        start_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String name = et_inputName.getText().toString().trim();
                if(name.isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter your name",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i=new Intent(MainActivity.this,QuizActivity.class);
                    i.putExtra("USER_NAME",name);
                    startActivity(i);
                }

            }
        });

    }
    private void init()
    {
        et_inputName=findViewById(R.id.et_inputName);
        start_button=findViewById(R.id.start_button);
    }
}