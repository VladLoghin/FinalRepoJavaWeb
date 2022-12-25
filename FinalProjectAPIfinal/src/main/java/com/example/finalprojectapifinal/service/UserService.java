package com.example.finalprojectapifinal.service;

import com.example.finalprojectapifinal.entity.Question;
import com.example.finalprojectapifinal.entity.User;
import com.example.finalprojectapifinal.entity.UserQuestionRating;
import com.example.finalprojectapifinal.entity.UserQuestionRatingTotal;
import com.example.finalprojectapifinal.exception.ResourceNotFoundException;
import com.example.finalprojectapifinal.repository.QuestionRepository;
import com.example.finalprojectapifinal.repository.UserQuestionRatingRepository;
import com.example.finalprojectapifinal.repository.UserRepository;
import com.example.finalprojectapifinal.requests.UserQuestionRatingRequest;
import com.example.finalprojectapifinal.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    private UserQuestionRatingRepository userQuestionRatingRepository;
    /*public User addUser(long id, UserRequest userRequest){
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("user id is not found"));
        User userToBeSaved = new User(userRequest);

        return userRepository.save(userToBeSaved);
    }*/

    public User getUser(long Id)
    {
        return userRepository.findById(Id).orElseThrow(
                ()->new ResourceNotFoundException("user id is not found"));
        //return teacherRepository.findAllByFirstNameIgnoreCase(firstNameParam);
    }

    public User updateUser(long id, UserRequest userRequest){
        if(userRepository.existsById(id)){
            User updateUser = new User();
            updateUser.setId(id);
            return userRepository.save(updateUser);
        }
        else {
            throw new ResourceNotFoundException("user not found");
        }
    }

    public List<UserQuestionRating> GetUserQuestionRatings(long Id, Date date) {

            return userQuestionRatingRepository.getUserQuestionRatingByUserRatingIdAndDate(Id, date);
    }

    public List<UserQuestionRatingTotal> GetUserQuestionRatingTotals(long Id){
        //return userQuestionRatingRepository.getUserQuestionRatingAvg(Id);
        List<UserQuestionRatingTotal> userQuestionRatingTotals = new ArrayList<>();
        List<UserQuestionRating> userQuestionRatings = userQuestionRatingRepository.getUserQuestionRatingByUserRatingId(Id);
        List<Date> dates = userQuestionRatings.stream().map(u->u.getDate()).distinct().collect(Collectors.toList());

        for(var i=0;i<dates.size();i++){
            int total = 0;
            for(var j=0;j<userQuestionRatings.size();j++){
                Date d = dates.get(i);
                Date d1= userQuestionRatings.get(j).getDate();
                if(d.compareTo(d1) == 0)
                    total+=userQuestionRatings.get(j).getRating();
            }
            userQuestionRatingTotals.add(new UserQuestionRatingTotal(dates.get(i), total));
        }

        return userQuestionRatingTotals;
    }

    public UserQuestionRating AddUserRatting(long userId, Date date, UserQuestionRatingRequest userQuestionRatingRequest){
        User user = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("user id is not found"));
        Question question = questionRepository.findById(userQuestionRatingRequest.getQuestionId()).orElseThrow(
                ()->new ResourceNotFoundException("question id is not found"));

        UserQuestionRating userQuestionRatingToBeSaved = new UserQuestionRating(userQuestionRatingRequest);
        userQuestionRatingToBeSaved.setUserRating(user);
        userQuestionRatingToBeSaved.getUserRating().setId(userId);
        userQuestionRatingToBeSaved.setDate(date);

        return userQuestionRatingRepository.save(userQuestionRatingToBeSaved);
    }

    public UserQuestionRating updateUserQuestionRating(long userId, Date date, UserQuestionRatingRequest userQuestionRatingRequest){
        User user = userRepository.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("user id is not found"));
        Question question = questionRepository.findById(userQuestionRatingRequest.getQuestionId()).orElseThrow(
                ()->new ResourceNotFoundException("user id is not found"));

        UserQuestionRating userQuestionRatingToBeUpdated = new UserQuestionRating(userQuestionRatingRequest);
        userQuestionRatingToBeUpdated.setId(userQuestionRatingRequest.getId());
        userQuestionRatingToBeUpdated.setUserRating(user);
        userQuestionRatingToBeUpdated.getUserRating().setId(userId);
        userQuestionRatingToBeUpdated.setDate(date);

        return userQuestionRatingRepository.save(userQuestionRatingToBeUpdated);
    }

    public void deleteAllQuestionRatingsForUser(long userId){
        if (userRepository.existsById(userId)) {
            userQuestionRatingRepository.deleteUserQuestionRatingsByUserRatingId(userId);
        }
        else{
            throw new ResourceNotFoundException("user not found");
        }
    }
}
