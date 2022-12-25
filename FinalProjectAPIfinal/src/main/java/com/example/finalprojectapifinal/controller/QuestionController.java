package com.example.finalprojectapifinal.controller;

import com.example.finalprojectapifinal.requests.QuestionRequest;
import com.example.finalprojectapifinal.response.QuestionResponse;
import com.example.finalprojectapifinal.service.QuestionService;
import com.example.finalprojectapifinal.entity.Question;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("")
    public List<QuestionResponse> getQuestions(){
        List<QuestionResponse> questionsResponse = new ArrayList<>();

        List<Question> questionsActives = questionService.getQuestions();
        for(var i=0; i<questionsActives.size();i++){
            QuestionResponse questionResponse = new QuestionResponse(questionsActives.get(i));
            questionsResponse.add(questionResponse);
        }

        return questionsResponse;
    }

}
