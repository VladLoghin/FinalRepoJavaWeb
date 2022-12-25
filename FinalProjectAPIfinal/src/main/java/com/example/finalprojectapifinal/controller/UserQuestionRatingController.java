package com.example.finalprojectapifinal.controller;

import com.example.finalprojectapifinal.entity.UserQuestionRating;
import com.example.finalprojectapifinal.requests.UserQuestionRatingRequest;
import com.example.finalprojectapifinal.response.UserQuestionRatingResponse;
import com.example.finalprojectapifinal.service.UserQuestionRatingService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/userquestionrating")
public class UserQuestionRatingController {

    @Autowired
    UserQuestionRatingService userQuestionRatingService;
/*
    @GetMapping("/{userId}?date={date}")
    public List<UserQuestionRatingResponse> getUserQuestionRatingByUserRating(@PathVariable long Id, @RequestParam String date) throws ParseException {

        List<UserQuestionRatingResponse> userQuestionRatingResponses= new ArrayList<>();

        List<UserQuestionRating> userQuestionRatings = userQuestionRatingService.GetUserQuestionRatings(Id, date);
        for (int i=0; i<userQuestionRatings.size(); i++) {
            userQuestionRatingResponses.add(new UserQuestionRatingResponse(userQuestionRatings.get(i)));
        }
        return userQuestionRatingResponses;
    }
*/

}
