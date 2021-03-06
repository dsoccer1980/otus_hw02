package ru.dsoccer1980.dao;

import com.opencsv.CSVReader;
import org.springframework.stereotype.Repository;
import ru.dsoccer1980.configs.YamlProps;
import ru.dsoccer1980.model.Question;
import ru.dsoccer1980.service.Localization;
import ru.dsoccer1980.util.exception.NotFoundException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Repository
public class QuestionDaoCSVImpl implements QuestionDao {

    private final Localization localization;
    private YamlProps props;

    public QuestionDaoCSVImpl(Localization localization, YamlProps props) {
        this.localization = localization;
        this.props = props;
    }

    @Override
    public List<Question> getAllQuestions() {
        String filenameLocale = MessageFormat.format(props.getFilename(), getPrefix());
        List<Question> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(
                        QuestionDaoCSVImpl.class.getClassLoader().getResourceAsStream(filenameLocale), "File not found"),
                        StandardCharsets.UTF_8));
             CSVReader csvReader = new CSVReader(reader)) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                questions.add(new Question(Integer.valueOf(record[0]), record[1], record[2]));
            }
        } catch (IOException e) {
            throw new NotFoundException(e.getMessage());
        }
        return questions;
    }

    private String getPrefix() {
        Locale locale = localization.getLocale();
        return locale.getLanguage().equals("en") ? "" : "_" + locale.toString();
    }

}
