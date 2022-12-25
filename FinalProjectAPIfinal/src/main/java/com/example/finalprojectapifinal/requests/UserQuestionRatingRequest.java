package com.example.finalprojectapifinal.requests;

import com.example.finalprojectapifinal.entity.UserQuestionRating;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserQuestionRatingRequest {
    private long id;
    @NotBlank
    private long questionId;
    @NotBlank
    private int rating;


}
