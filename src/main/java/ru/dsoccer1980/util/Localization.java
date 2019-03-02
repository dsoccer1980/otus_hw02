package ru.dsoccer1980.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class Localization {

    private MessageSource messageSource;
    @Value("${locale.prop}")
    protected String locale;

    public Localization(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String property) {
        return messageSource.getMessage(
                property,
                null,
                new Locale(locale));
    }

    public String getMessage(String property, Object[] args) {
        return messageSource.getMessage(
                property,
                args,
                new Locale(locale));
    }
}
