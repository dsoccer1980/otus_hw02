package ru.dsoccer1980.util;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class Localization {

    private MessageSource messageSource;
    private Locale locale = Locale.getDefault();

    public Localization(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String property) {
        return messageSource.getMessage(
                property,
                null,
                locale);
    }

    public String getMessage(String property, Object[] args) {
        return messageSource.getMessage(
                property,
                args,
                locale);
    }

    public Locale getLocale() {
        return locale;
    }
}
