package com.example.finalprojectapifinal.response;

import com.example.finalprojectapifinal.entity.UserQuestionRatingTotal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserQuestionRatingTotalResponse {
    private Date date;
    private double ratingTotal;

    public UserQuestionRatingTotalResponse(UserQuestionRatingTotal userQuestionRating){
        date = userQuestionRating.getDate();
        ratingTotal =userQuestionRating.getRatingTotal();
    }
}
