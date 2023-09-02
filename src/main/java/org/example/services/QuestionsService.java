package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entites.Questions;
import org.example.models.QuestionForm;
import org.example.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuestionsService {
    private final QuestionsRepository repository;
    public List<Questions> getQuestionsByTopic(Integer topicId) {
        List<Questions> questions = repository.findByTopicId(topicId);
        List<String> questionToString = questions.stream().map(x->x.getQuestion()).toList();

     return questions;
    }

    public Questions saveQuestion(QuestionForm form) {
        Questions qm = new Questions();
        qm.setQuestion(form.getQuestion());
        qm.setTopicId(form.getOptions().get(0).getTopicId());
        List<Questions> questions = repository.findAll();
        Integer lastQuestionId = questions.stream().reduce((e1,e2)->e2).get().getQuestionId();
        qm.setQuestionId(lastQuestionId + 1);
        Questions result = repository.saveAndFlush(qm);

        return result;
    }

    public List<String> getQuestionsRandom() {
        List<Questions> questionsAll = repository.findAll();
        int max = questionsAll.size();
        Random random = new Random();
        List<String> questionsList = new ArrayList<>();
        while (questionsList.size() < 4){
            int randomNum = random.nextInt(max - 1);
            questionsList.add(questionsAll.get(randomNum).getQuestion());
        }
        return questionsList;
    }

}
