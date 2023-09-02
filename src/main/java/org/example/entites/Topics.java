package org.example.entites;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "public", name = "java_topics")
public class Topics {
    @Id
    private Integer topicId;
    private String topicName;
}

