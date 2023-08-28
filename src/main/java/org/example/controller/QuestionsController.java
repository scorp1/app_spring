package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entites.QuestionsModel;
import org.example.services.QuestionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionsController
{
    private final QuestionsService questionsService;
    @GetMapping("/topic/{id}")
    public String getQuestionsByTopic(@PathVariable Integer id, Model model) {

        List<QuestionsModel> questions = questionsService.getQuestionsByTopic(id);
        model.addAttribute("questions", questions);
        model.addAttribute("question", new QuestionsModel());

        return "questions";
    }
}
