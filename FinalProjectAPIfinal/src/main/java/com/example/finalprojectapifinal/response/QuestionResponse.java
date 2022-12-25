package com.example.finalprojectapifinal.response;

import com.example.finalprojectapifinal.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    long questionId;
    private String description;

    private boolean active;

    private int rating;

    public QuestionResponse(Question question){
        description = question.getDescription();
        active=question.isActive();
        questionId =question.getQuestionId();
    }
}
