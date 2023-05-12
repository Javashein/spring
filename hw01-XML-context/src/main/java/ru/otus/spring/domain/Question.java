package ru.otus.spring.domain;

public class Question {
    private final int id;
    private final String name;

    public Question(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
