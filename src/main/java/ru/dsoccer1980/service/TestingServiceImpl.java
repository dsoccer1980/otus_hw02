package ru.dsoccer1980.service;

import org.springframework.stereotype.Service;
import ru.dsoccer1980.model.Question;
import ru.dsoccer1980.util.Localization;

import java.util.List;

@Service
public class TestingServiceImpl implements TestingService {

    private final QuestionService questionService;
    private final IOService ioService;
    private final Localization localization;
    private int rightAnswersCount = 0;

    public TestingServiceImpl(QuestionService questionService, IOService ioService, Localization localization) {
        this.questionService = questionService;
        this.ioService = ioService;
        this.localization = localization;
    }

    @Override
    public void showQuestions() {
        List<Question> questions = questionService.getAllQuestions();

        for (Question question : questions) {
            ioService.write(question.getQuestion());
            ioService.write(localization.getMessage("write.answer"));
            String userAnswer = ioService.read();
            String rightAnswer = question.getAnswer();
            if (userAnswer.equals(rightAnswer)) {
                this.rightAnswersCount++;
            }
        }
    }

    @Override
    public int getResult() {
        return rightAnswersCount;
    }

}
