package com.example.finalprojectapifinal.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UserQuestionRatingTotal {
    private Date date;
    private int ratingTotal;

    public UserQuestionRatingTotal(Date date, int ratingAvg){
        this.date=date;
        this.ratingTotal =ratingAvg;
    }
}
