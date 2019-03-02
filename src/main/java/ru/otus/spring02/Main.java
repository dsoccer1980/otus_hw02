package ru.otus.spring02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.spring02.domain.Person;
import ru.otus.spring02.service.PersonService;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = null;

        PersonService service = context.getBean(PersonService.class);

        Person ivan = service.getByName("Ivan");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }
}
