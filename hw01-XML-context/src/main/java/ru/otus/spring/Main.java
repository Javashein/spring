package ru.otus.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.application.ApplicationRunner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        ApplicationRunner applicationRunner = ctx.getBean(ApplicationRunner.class);
        applicationRunner.run();
    }
}
