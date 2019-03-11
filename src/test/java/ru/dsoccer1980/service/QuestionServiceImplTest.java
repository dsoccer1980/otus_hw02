package ru.dsoccer1980.service;

import org.junit.jupiter.api.Test;
import ru.dsoccer1980.dao.QuestionDao;
import ru.dsoccer1980.model.Question;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionServiceImplTest {

    @Test
    void getAllQuestions() {
        List<Question> questions = Arrays.asList(new Question(1, "", ""), new Question(2, "", ""));
        QuestionDao questionDao = mock(QuestionDao.class);
        when(questionDao.getAllQuestions()).thenReturn(questions);

        QuestionService questionService = new QuestionServiceImpl(questionDao);
        assertEquals(questions, questionService.getAllQuestions());
    }
}