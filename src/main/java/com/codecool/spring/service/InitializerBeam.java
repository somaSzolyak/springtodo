package com.codecool.spring.service;

import com.codecool.spring.model.Status;
import com.codecool.spring.model.Todo;
import org.springframework.stereotype.Component;

@Component
public class InitializerBeam {

    public InitializerBeam(TodoService todoService) {
        todoService.add(new Todo("asd", 112, Status.ACTIVE));
        todoService.add(new Todo("sdf", 321, Status.COMPLETE));
        todoService.add(new Todo("dfg", 231, Status.ACTIVE));
    }
}
