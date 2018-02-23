package com.codecool.spring.controller;

import com.codecool.spring.model.Status;
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

    private String add(Todo todo) {
        todoService.add(todo);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "index";
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public String addNewTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "todoform";
    }

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public String addNewTodo(@ModelAttribute Todo todo) {
        todo.setStatus(Status.ACTIVE);
        add(todo);
        return "redirect:/";
    }

    @RequestMapping(value = "/todos/completed/delete", method = RequestMethod.GET)
    public String removeCompleted() {
        todoService.deleteCompleted();
        return "index";
    }

    @RequestMapping(value = "/todos/remove/{id}", method = RequestMethod.GET)
    public String removeById(@PathVariable("id") int id) {
        todoService.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
    public String updateById(@PathVariable("id") long id) {
        todoService.updateById(id);
        return "index";
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
