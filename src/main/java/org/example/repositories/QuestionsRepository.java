package org.example.repositories;

import org.example.entites.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
    List<Questions> findAll();

    List<Questions> findByTopicId(Integer topicId);
}
