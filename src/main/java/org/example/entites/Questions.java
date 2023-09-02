package org.example.entites;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(schema = "public", name = "questions")
public class Questions {
    @Id
    private Integer questionId;
    private String question;
    private Integer topicId;
}
