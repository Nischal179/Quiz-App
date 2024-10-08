package com.nischal.quizapp.dao;

import com.nischal.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT CAST(:numQ AS " +
            "INTEGER)",
            nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
