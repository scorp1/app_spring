package org.example.models;

import lombok.Data;
import org.example.entites.Topics;

import java.util.List;

@Data
public class QuestionForm {
    private List<Topics> options;
    private String question;
}
