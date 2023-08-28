package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entites.QuestionsModel;
import org.example.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionsService {
    private final QuestionsRepository repository;
    public List<QuestionsModel> getQuestionsByTopic(Integer topicId) {
        List<QuestionsModel> questions = repository.findByTopicId(topicId);
        List<String> questtionToString = questions.stream().map(x->x.getQuestion()).toList();

     return questions;
    }
}
