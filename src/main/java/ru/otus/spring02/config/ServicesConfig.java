package ru.otus.spring02.config;

import ru.otus.spring02.dao.PersonDao;
import ru.otus.spring02.service.PersonService;
import ru.otus.spring02.service.PersonServiceImpl;

public class ServicesConfig {

    public PersonService personService(PersonDao dao) {
        return new PersonServiceImpl(dao);
    }
}
