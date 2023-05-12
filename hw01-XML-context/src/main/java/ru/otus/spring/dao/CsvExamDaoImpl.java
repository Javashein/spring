package ru.otus.spring.dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Exam;
import ru.otus.spring.domain.Question;
import ru.otus.spring.exception.ReadFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvExamDaoImpl implements ExamDao {
    private final String fileName;

    public CsvExamDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Exam> findAll() {
        List<Exam> exams = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {
            Iterable<CSVRecord> csvRecords = CSVFormat.RFC4180.builder().setHeader().setSkipHeaderRecord(true).build().parse(in);
            for (CSVRecord csvRecord : csvRecords) {
                Question question = new Question(Integer.parseInt(csvRecord.get("question_id")), csvRecord.get("question_name"));
                List<Answer> answers = new ArrayList<>();
                answers.add(new Answer(1, csvRecord.get("first_answer")));
                answers.add(new Answer(2, csvRecord.get("second_answer")));
                answers.add(new Answer(3, csvRecord.get("third_answer")));
                answers.add(new Answer(4, csvRecord.get("fourth_answer")));
                exams.add(new Exam(question, answers));
            }
        } catch (IOException ioException) {
            throw new ReadFileException("Failed to read file ", ioException);
        }
        return Collections.unmodifiableList(exams);
    }
}
