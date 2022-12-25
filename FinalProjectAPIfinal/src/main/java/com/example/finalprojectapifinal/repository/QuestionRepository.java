package com.example.finalprojectapifinal.repository;

import com.example.finalprojectapifinal.entity.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
        public List<Question> getQuestionsByActiveIsTrue();
}
