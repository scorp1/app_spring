package org.example.repositories;

import org.example.entites.Topics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topics, Integer> {

}
