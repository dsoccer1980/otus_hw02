package ru.dsoccer1980.dao;

import org.junit.jupiter.api.Test;
import ru.dsoccer1980.configs.YamlProps;
import ru.dsoccer1980.model.Question;
import ru.dsoccer1980.service.Localization;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionDaoCSVImplTest {

    @Test
    void getAllQuestions() {
        Localization localization = mock(Localization.class);
        YamlProps props = mock(YamlProps.class);

        when(localization.getLocale()).thenReturn(Locale.ENGLISH);
        when(props.getFilename()).thenReturn("questions{0}.csv");

        QuestionDao questionDao = new QuestionDaoCSVImpl(localization, props);
        List<Question> allQuestions = questionDao.getAllQuestions();
        assertEquals("[[Question1?, A1], [Question2?, A2]]", Arrays.toString(allQuestions.toArray()));
    }

    @Test
    void fileNotFound() {
        Localization localization = mock(Localization.class);
        YamlProps props = mock(YamlProps.class);

        when(localization.getLocale()).thenReturn(Locale.ENGLISH);
        when(props.getFilename()).thenReturn("wrong.csv");

        QuestionDao questionDao = new QuestionDaoCSVImpl(localization, props);
        assertThrows(NullPointerException.class, questionDao::getAllQuestions);
    }
}