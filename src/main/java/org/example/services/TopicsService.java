package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entites.Topics;
import org.example.repositories.TopicsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicsService {
    private final TopicsRepository repository;

    public List<Topics> getAllTopics() {
        List<Topics> topics = repository.findAll();
        List<String> options = topics.stream().map(x->x.getTopicName()).toList();

        return topics;
    }
}
