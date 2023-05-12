package ru.otus.spring.service;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Exam;
import ru.otus.spring.domain.Question;

import java.util.List;

public class ExamFormatterImpl implements ExamFormatter{
    @Override
    public String format(Exam exam) {
        StringBuilder examText = new StringBuilder();
        Question question = exam.getQuestion();
        List<Answer> answers = exam.getAnswers();
        examText.append(question.getId()).append(" ").append(question.getName()).append( "\n");
        for (int i = 1; i <= answers.size(); i++) {
            examText.append(answers.get(i - 1).getId()).append(" ").append(answers.get(i - 1).getName()).append( "\n");
        }
        examText.append("\n");
        return examText.toString();
    }
}
