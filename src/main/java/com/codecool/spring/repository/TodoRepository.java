package com.codecool.spring.repository;

import com.codecool.spring.model.Status;
import com.codecool.spring.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByStatus(Status status);
}
