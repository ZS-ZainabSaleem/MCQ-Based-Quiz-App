package com.example.mcqquizapp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class QuizData {
    public static List<QuizModel> getQuestions()
    {
        List<QuizModel> questions=new ArrayList<>();
        questions.add(new QuizModel("What does HTML stand for?",
                Arrays.asList("Hyper Text Markup Language", "High Tech Machine Learning",
                        "Home Tool Management Language", "Hyper Transfer Markup Language"), 0));
        questions.add(new QuizModel("Which data structure follows the LIFO (Last In, First Out) principle?",
                Arrays.asList("Queue", "Stack", "Linked List", "Array"), 1));
        questions.add(new QuizModel("Which sorting algorithm has the best average-case time complexity?",
                Arrays.asList("Bubble Sort", "Quick Sort", "Merge Sort", "Selection Sort"), 2));
        questions.add(new QuizModel("Which protocol is used for secure communication over the internet?",
                Arrays.asList("HTTP", "FTP", "SSH", "HTTPS"), 3));
        questions.add(new QuizModel("Which of the following is NOT an object-oriented programming language?",
                Arrays.asList("Java", "Python", "C", "C++"), 2));
        questions.add(new QuizModel("Which programming language is used for Android app development?",
                Arrays.asList("Swift", "Kotlin", "C#", "Python"), 1));
        questions.add(new QuizModel("Which data structure follows the FIFO (First In, First Out) principle?",
                Arrays.asList("Queue", "Stack", "Linked List", "Array"), 0));
        questions.add(new QuizModel("Which company developed the Java programming language?",
                Arrays.asList("Microsoft", "Google", "Sun Microsystems", "Apple"), 2));
        questions.add(new QuizModel("What does SQL stand for?",
                Arrays.asList("Structured Query Language", "Simple Quick Language",
                        "System Query Logic", "Sequential Query List"), 0));
        questions.add(new QuizModel("Which OOP principle allows a subclass to provide a specific implementation of a method already defined in its superclass?",
                Arrays.asList("Encapsulation", "Polymorphism", "Abstraction", "Inheritance"), 1));
        return questions;
    }
}
