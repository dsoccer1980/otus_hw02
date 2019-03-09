package ru.dsoccer1980.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionTest {

    @Test
    void correctCreationQuestion() {
        String questionName = "Question1";
        String answer = "Answer1";

        Question question = new Question(1, questionName, answer);
        assertThat(question).hasFieldOrPropertyWithValue("question", questionName);
        assertThat(question).hasFieldOrPropertyWithValue("answer", answer);
    }
}