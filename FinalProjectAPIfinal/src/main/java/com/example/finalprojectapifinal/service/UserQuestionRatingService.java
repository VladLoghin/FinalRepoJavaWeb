package com.example.finalprojectapifinal.service;

import com.example.finalprojectapifinal.entity.User;
import com.example.finalprojectapifinal.entity.UserQuestionRating;
import com.example.finalprojectapifinal.exception.ResourceNotFoundException;
import com.example.finalprojectapifinal.repository.UserQuestionRatingRepository;
import com.example.finalprojectapifinal.repository.UserRepository;
import com.example.finalprojectapifinal.requests.UserQuestionRatingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQuestionRatingService {

    @Autowired
    private UserQuestionRatingRepository userQuestionRatingRepository;
    @Autowired
    private UserRepository userRepository;

    /*public List<UserQuestionRating> GetUserQuestionRatings(long Id, String date) throws ParseException {
        if(date.isEmpty()|| date.isBlank())
            return userQuestionRatingRepository.getUserQuestionRatingByUserRating(Id);
        else{
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date d = formatter.parse(date);

            return userQuestionRatingRepository.getUserQuestionRatingByUserRatingAndDate(Id, d);
        }
    }*/



    /*public UserQuestionRatingService updateUserQuestionRating(long id, UserQuestionRatingRequest userQuestionRatingRequest){
        if(userQuestionRatingRepository.existsById(id)){
            UserQuestionRating userQuestionRating = new UserQuestionRating();
            updateUserQuestionRating(id, userQuestionRatingRequest);
            return userQuestionRatingRepository.save(updateUserQuestionRating);
        }
        else{
            throw new ResourceNotFoundException("user question id not found");
        }
    }*/

}
