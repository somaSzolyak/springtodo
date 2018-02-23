package com.codecool.spring.service;

import com.codecool.spring.model.Status;
import com.codecool.spring.model.Todo;
import com.codecool.spring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll(){return todoRepository.findAll();}

    public void add(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteCompleted() {
        todoRepository.delete(todoRepository.findByStatus(Status.COMPLETE));
    }

    public void deleteById(int id) {
        todoRepository.delete((long) id);
    }

    public void updateById(long id) {
    }
}
