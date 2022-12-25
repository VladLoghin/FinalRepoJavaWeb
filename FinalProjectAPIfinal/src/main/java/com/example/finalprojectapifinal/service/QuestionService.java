package com.example.finalprojectapifinal.service;

import com.example.finalprojectapifinal.entity.Question;
import com.example.finalprojectapifinal.exception.ResourceNotFoundException;
import com.example.finalprojectapifinal.repository.QuestionRepository;
import com.example.finalprojectapifinal.requests.QuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestions(){
        List<Question> questions = questionRepository.getQuestionsByActiveIsTrue();
        return questions;
    }

    public Question updateQuestion(long questionId, QuestionRequest questionRequest){
        if(questionRepository.existsById(questionId)){
            Question questionToBeUpdated = new Question();
            questionToBeUpdated.setQuestionId(questionId);
            return questionRepository.save(questionToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("question id not found");
        }
    }


}
