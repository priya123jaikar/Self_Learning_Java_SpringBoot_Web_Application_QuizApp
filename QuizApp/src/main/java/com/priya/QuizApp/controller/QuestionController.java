package com.priya.QuizApp.controller;

import com.priya.QuizApp.model.Question;
import com.priya.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Since I want to accept the request so I am making as a rest controller
@RequestMapping("Question") //whatever the request coming for question so this is a controller who will handel it.
public class QuestionController {
    //I want to accept the request of /allQuestions so for that I am creating a method

    @Autowired  //since we are using spring so we can use autowired instead of new
    QuestionService questionService;  //object of service
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("add")
    public  ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }



}
