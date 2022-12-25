package com.example.finalprojectapifinal.controller;

import com.example.finalprojectapifinal.entity.User;
import com.example.finalprojectapifinal.entity.UserQuestionRating;
import com.example.finalprojectapifinal.entity.UserQuestionRatingTotal;
import com.example.finalprojectapifinal.requests.UserQuestionRatingRequest;
import com.example.finalprojectapifinal.response.UserQuestionRatingTotalResponse;
import com.example.finalprojectapifinal.response.UserQuestionRatingResponse;
import com.example.finalprojectapifinal.response.UserResponse;
import com.example.finalprojectapifinal.service.UserQuestionRatingService;
import com.example.finalprojectapifinal.service.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@Validated
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserQuestionRatingService userQuestionRatingService;


    @GetMapping("/{Id}")
    public UserResponse getUser(@PathVariable long Id)
    {
        User user = userService.getUser(Id);
        return new UserResponse(user);
    }

    @GetMapping("/{Id}/questions")
    public List<UserQuestionRatingResponse> getUserQuestionRatingByUserRating(@PathVariable long Id, @RequestParam @PastOrPresent @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate date) {

        List<UserQuestionRatingResponse> userQuestionRatingResponses= new ArrayList<>();

        Date myDate = java.util.Date.from(date.atStartOfDay(ZoneId.of( "America/Montreal" )).toInstant());
        List<UserQuestionRating> userQuestionRatings = userService.GetUserQuestionRatings(Id, myDate);
        for (int i=0; i<userQuestionRatings.size(); i++) {
            userQuestionRatingResponses.add(new UserQuestionRatingResponse(userQuestionRatings.get(i)));
        }
        return userQuestionRatingResponses;
    }

    @GetMapping("/{Id}/questionsRatingTotal")
    public List<UserQuestionRatingTotalResponse> getUserQuestionRatingTotal(@PathVariable long Id){
        List<UserQuestionRatingTotalResponse> userQuestionRatingTotalResponse = new ArrayList<>();

        List<UserQuestionRatingTotal> userQuestionRatingTotal = userService.GetUserQuestionRatingTotals(Id);
        for (int i=0; i<userQuestionRatingTotal.size(); i++) {
            userQuestionRatingTotalResponse.add(new UserQuestionRatingTotalResponse(userQuestionRatingTotal.get(i)));
        }

        return userQuestionRatingTotalResponse;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{Id}/questions")
    public List<UserQuestionRatingResponse> addUserQuestionRating(@PathVariable long Id, @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate date, @RequestBody List<UserQuestionRatingRequest> userQuestionRatingRequest) {
        Date myDate = java.util.Date.from(date.atStartOfDay(ZoneId.of( "America/Montreal" )).toInstant());
        List<UserQuestionRatingResponse> listeUserQuestinRatingResponse = new ArrayList<>();
        for (var i=0; i<userQuestionRatingRequest.size();i++) {
            UserQuestionRatingResponse u = new UserQuestionRatingResponse(userService.AddUserRatting(Id, myDate, userQuestionRatingRequest.get(i)));
            listeUserQuestinRatingResponse.add(u);
        }

        return listeUserQuestinRatingResponse;
    }

    @PutMapping("/{Id}/questions")
    public List<UserQuestionRatingResponse> updateUserQuestionRating (@PathVariable long Id, @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate date, @RequestBody List<UserQuestionRatingRequest> userQuestionRatingRequest){
        Date myDate = java.util.Date.from(date.atStartOfDay(ZoneId.of( "America/Montreal" )).toInstant());
        List<UserQuestionRatingResponse> listeUserQuestinRatingResponse = new ArrayList<>();
        for (var i=0; i<userQuestionRatingRequest.size();i++) {
            UserQuestionRatingResponse u = new UserQuestionRatingResponse(userService.updateUserQuestionRating(Id, myDate, userQuestionRatingRequest.get(i)));
            listeUserQuestinRatingResponse.add(u);
        }

        return listeUserQuestinRatingResponse;
    }
    @Transactional
    @DeleteMapping("/{Id}/questions")
    public void deleteUserQuestionRating(@PathVariable long Id){
        userService.deleteAllQuestionRatingsForUser(Id);
    }
}
