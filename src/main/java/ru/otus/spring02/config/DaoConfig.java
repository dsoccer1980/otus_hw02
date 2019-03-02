package ru.otus.spring02.config;

import ru.otus.spring02.dao.PersonDao;
import ru.otus.spring02.dao.PersonDaoSimple;

public class DaoConfig {

    public PersonDao personDao() {
        return new PersonDaoSimple();
    }
}
