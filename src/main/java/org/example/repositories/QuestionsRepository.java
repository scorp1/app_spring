package org.example.repositories;

import org.example.entites.QuestionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<QuestionsModel, Integer> {
    List<QuestionsModel> findAll();

    List<QuestionsModel> findByTopicId(Integer topicId);
}
