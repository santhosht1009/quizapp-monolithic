package com.example.quiz.controller;

import com.example.quiz.dto.QuestionWrapper;
import com.example.quiz.dto.Response;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
@Autowired
    QuizService quizService;
    @PostMapping("/createquiz")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam Integer numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/getquiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> createQuiz(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }
}
