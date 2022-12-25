package com.example.finalprojectapifinal.repository;

import com.example.finalprojectapifinal.entity.UserQuestionRating;
import com.example.finalprojectapifinal.entity.UserQuestionRatingTotal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface UserQuestionRatingRepository extends CrudRepository<UserQuestionRating, Long> {
    public List<UserQuestionRating> getUserQuestionRatingByUserRatingId(long Id);

    public List<UserQuestionRating> getUserQuestionRatingByUserRatingIdAndDate(long Id, Date date);

    public void deleteUserQuestionRatingsByUserRatingId(long Id);

    public void removeAllByUserRatingId(long Id);

    public List<UserQuestionRating> getByUserRatingId(long Id);

    @Query(value = "select date, avg(rating) ratingAvg from User_question_rating group by date having user_id=?1",  nativeQuery = true)
    List<UserQuestionRatingTotal> getUserQuestionRatingAvg(long Id);
}
