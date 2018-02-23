package com.codecool.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private Status status;

    public Todo() {}

    public Todo(String title, int id, Status status) {
        this.title = title;
        this.id = id;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void toggleStatus() {
        this.status = isComplete() ? Status.ACTIVE : Status.COMPLETE;
    }

    public String statusToString() { return isComplete() ? "COMPLETE" : "ACTIVE";}

    public boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    public static Todo create(String title) {
        return new Todo(title, Integer.parseInt(UUID.randomUUID().toString()), Status.ACTIVE);
    }

}
