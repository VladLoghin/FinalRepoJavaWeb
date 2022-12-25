package com.example.finalprojectapifinal.repository;

import com.example.finalprojectapifinal.entity.User;
import com.example.finalprojectapifinal.entity.UserQuestionRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //public Optional<User> findById(long Id);


}
