package com.example.finalprojectapifinal.requests;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    @NotBlank
    private String description;
    @NotBlank
    private boolean active;

    public QuestionRequest(QuestionRequest questionRequest){
        description = questionRequest.getDescription();
        active = questionRequest.isActive();
    }

}
