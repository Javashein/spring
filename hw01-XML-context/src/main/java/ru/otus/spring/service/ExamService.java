package ru.otus.spring.service;

import ru.otus.spring.domain.Exam;

import java.util.List;

public interface ExamService {
    List<Exam> getExams();
    void printExams();
}
