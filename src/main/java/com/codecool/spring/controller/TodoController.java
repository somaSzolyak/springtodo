package com.codecool.spring.controller;

import com.codecool.spring.model.Todo;
import com.codecool.spring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

//        Render main UI
//        we don't need to implement this in spring but unsure how the fck does spring knows the main route
//        get("/", (req, res) -> renderTodos(req));

    private String add(Todo todo) {
        todoService.add(todo);
        return "todos";
    }

    @RequestMapping(value = "todos", method = RequestMethod.GET)
    public String addNewTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "todos";
    }

    @RequestMapping(value = "todos", method = RequestMethod.POST)
    public String addNewTodo(@ModelAttribute Todo todo) {
        add(todo);
        return "todos";
    }

    @RequestMapping(value = "todos/completed", method = RequestMethod.DELETE)
    public String removeCompleted() {
        todoService.deleteCompleted();
        return "todos";
    }

    @RequestMapping(value = "todos/{id}", method = RequestMethod.DELETE)
    public String removeById(@PathVariable("id") long id) {
        todoService.deleteById(id);
        return "todos";
    }

    @RequestMapping(value = "todos/{id}", method = RequestMethod.PUT)
    public String updateById(@PathVariable("id") long id) {
        todoService.updateById(id);
        return "todos";
    }

//
//        // Toggle all status
//        put("/todos/toggle_status", (req, res) -> {
//            TodoDao.toggleAll(req.queryParams("toggle-all") != null);
//            return renderTodos(req);
//        });
//
//        // Update by id
//        put("/todos/:id", (req, res) -> {
//            TodoDao.update(req.params("id"), req.queryParams("todo-title"));
//            return renderTodos(req);
//        });
//
//        // Toggle status by id
//        put("/todos/:id/toggle_status", (req, res) -> {
//            TodoDao.toggleStatus(req.params("id"));
//            return renderTodos(req);
//        });
//
//        // Edit by id
//        get("/todos/:id/edit", (req, res) -> renderEditTodo(req));
}
