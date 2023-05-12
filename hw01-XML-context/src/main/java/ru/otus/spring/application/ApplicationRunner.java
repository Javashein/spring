package ru.otus.spring.application;

import ru.otus.spring.exception.PrintExamsException;
import ru.otus.spring.service.*;

public class ApplicationRunner {
    private final IOService ioService;
    private final ExamService examService;

    public ApplicationRunner(IOService ioService,  ExamService examService) {
        this.ioService = ioService;
        this.examService = examService;
    }

    public void run() {
        try {
            examService.printExams();
        } catch (PrintExamsException printExamsException) {
            ioService.outputString("Failed to print exams!");
        }
    }
}
