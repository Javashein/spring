package ru.otus.spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.dao.CsvExamDaoImpl;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Exam;
import ru.otus.spring.domain.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;


class CsvExamDaoImplTest {
    private static final String EXAM_FILE = "/test_exam.csv";

    @DisplayName("Check all exams are found")
    @Test
    void checkFindAllExams() {
        List<Exam> expectedExams = new ArrayList<>();
        var firstExpectedExam = new Exam (new Question(1, "What does GUI stand for?"),
                Arrays.asList(new Answer(1, "Graphical User Interface"), new Answer(2, "Gimme Ur Internet"),
                        new Answer(3, "Grand User Interface"), new Answer(4, "Graphical Useful Interface")));
        var secondExpectedExam = new Exam (new Question(2, "Which one of the following is not a correct array declaration?"),
                Arrays.asList(new Answer(1, "Int arr[] = int [5] new"), new Answer(2, "Int [] arr = new int[5]"),
                        new Answer(3, "Int arr[] = new int[5]"), new Answer(4, "Int arr[] = new int[5]")));
        var thirdExpectedExam = new Exam (new Question(3, "The TreeMap class is used to implement"),
                Arrays.asList(new Answer(1, "Map interface"), new Answer(2, "NavigableMap"),
                        new Answer(3, "AbstractMap Class"), new Answer(4, "All of the above")));
        var fourthExpectedExam = new Exam (new Question(4, "How many classes we are able to extend in Java?"),
                Arrays.asList(new Answer(1, "Only one class"), new Answer(2, "Two class"),
                        new Answer(3, "Three class"), new Answer(4, "Four class")));
        var fifthExpectedExam = new Exam (new Question(5, "Which keyword is used for using interface in class?"),
                Arrays.asList(new Answer(1, "Extend"), new Answer(2, "Throw"),
                        new Answer(3, "Implements"), new Answer(4, "None of the above")));
        expectedExams.add(firstExpectedExam);
        expectedExams.add(secondExpectedExam);
        expectedExams.add(thirdExpectedExam);
        expectedExams.add(fourthExpectedExam);
        expectedExams.add(fifthExpectedExam);
        List<Exam> factExams = new CsvExamDaoImpl(EXAM_FILE).findAll();
        assertThat(factExams).usingRecursiveComparison().isEqualTo(expectedExams);
    }
}
