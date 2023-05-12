package ru.otus.spring.dao;

import ru.otus.spring.domain.Exam;

import java.util.List;

public interface ExamDao {
    List<Exam> findAll();
}
