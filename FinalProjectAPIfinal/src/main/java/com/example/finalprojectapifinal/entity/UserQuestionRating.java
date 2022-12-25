package com.example.finalprojectapifinal.entity;

import com.example.finalprojectapifinal.requests.UserQuestionRatingRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="UserQuestionRating")
@NoArgsConstructor
@Getter
@Setter
public class UserQuestionRating {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @ManyToOne
        @JoinColumn(name="user_id", nullable = false)
        private User userRating;

        @ManyToOne
        @JoinColumn(name="question_id", nullable = false)
        private Question questionRating;

        @Column(name="rating", nullable = false)
        private int rating;

        @Column(name="date", nullable = false)
        private Date date;

        public UserQuestionRating(UserQuestionRatingRequest userQuestionRatingRequest){
                questionRating = new Question(userQuestionRatingRequest.getQuestionId());
                rating = userQuestionRatingRequest.getRating();
                //date = userQuestionRatingRequest.getDate();
        }
    }


