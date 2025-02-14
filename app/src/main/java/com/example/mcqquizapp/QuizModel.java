package com.example.mcqquizapp;
import java.util.List;
public class QuizModel {
   private String questionText;
   private List<String> options;
   private int correctAnswereIndex;
    public QuizModel(String questionText,List<String> options, int correctAnswereIndex){
        this.questionText=questionText;
        this.options=options;
        this.correctAnswereIndex=correctAnswereIndex;
    }
    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswereIndex;
    }
}
