package ru.otus.spring.exception;

public class ReadFileException extends RuntimeException {
    public ReadFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
