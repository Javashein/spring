package ru.otus.spring.service;

import ru.otus.spring.dao.ExamDao;
import ru.otus.spring.domain.Exam;

import java.util.List;

public class ExamServiceImpl implements ExamService{
    private final IOService outputService;
    private final ExamDao examDao;
    private final ExamFormatter examFormatter;

    public ExamServiceImpl(IOService outputService, ExamDao examDao, ExamFormatter examFormatter) {
        this.outputService = outputService;
        this.examDao = examDao;
        this.examFormatter = examFormatter;
    }

    @Override
    public List<Exam> getExams() {
        return examDao.findAll();
    }


    @Override
    public void printExams() {
        getExams().forEach(ex -> outputService.outputString(examFormatter.format(ex)));
    }
}
