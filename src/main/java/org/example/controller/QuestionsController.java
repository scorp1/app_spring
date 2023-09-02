package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entites.Questions;
import org.example.models.QuestionForm;
import org.example.services.QuestionsService;
import org.example.services.TopicsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionsController
{
    private final QuestionsService questionsService;
    private final TopicsService topicsService;
    @GetMapping("/topic/{id}")
    public String getQuestionsByTopic(@PathVariable Integer id, Model model) {

        List<Questions> questions = questionsService.getQuestionsByTopic(id);
        model.addAttribute("questions", questions);
        model.addAttribute("question", new Questions());

        return "questions/by-topic";
    }

    @GetMapping("/random")
    public String getQuestionRandom(Model model) {
        List<String> questions = questionsService.getQuestionsRandom();
        model.addAttribute("questions", questions);

        return "questions/random";
    }

    @GetMapping("/add")
    public String addQuestion(Model model) {
        System.out.println("add question !");
        QuestionForm form = new QuestionForm();
        form.setOptions(topicsService.getAllTopics());
        model.addAttribute( "form", form);

        return "questions/add";
    }

    @PostMapping("/save")
    public String saveFrom(@ModelAttribute QuestionForm form) {
        try {
            Questions result = questionsService.saveQuestion(form);

            return "redirect/success";
        }catch (Exception e) {

            return "redirect/error";
        }

    }
}
