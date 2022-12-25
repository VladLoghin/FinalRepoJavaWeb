package com.example.finalprojectapifinal.response;

import com.example.finalprojectapifinal.entity.UserQuestionRating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserQuestionRatingResponse {
    private long id;
    //private UserResponse userRating;
    private long userId;

    //private QuestionResponse questionRating;
    private long questionId;
    private String description;
    private int rating;

    //private Date date;

    public UserQuestionRatingResponse(UserQuestionRating userQuestionRating)
    {
        id= userQuestionRating.getId();
        //userRating = new UserResponse(userQuestionRating.getUserRating());
        userId = (new UserResponse(userQuestionRating.getUserRating())).getId();
        //questionRating = new QuestionResponse(userQuestionRating.getQuestionRating());
        questionId=(new QuestionResponse(userQuestionRating.getQuestionRating())).getQuestionId();
        description = (new QuestionResponse(userQuestionRating.getQuestionRating())).getDescription();
        rating = userQuestionRating.getRating();
        //date = userQuestionRating.getDate();
    }
}
