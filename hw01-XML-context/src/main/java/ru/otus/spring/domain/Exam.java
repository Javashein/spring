package ru.otus.spring.domain;

import java.util.List;

public class Exam {
    private final Question question;
    private final List<Answer> answers;

    public Exam(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
