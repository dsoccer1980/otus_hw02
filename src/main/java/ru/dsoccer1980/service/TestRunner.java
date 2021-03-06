package ru.dsoccer1980.service;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TestRunner {

    private final TestingService testingService;
    private final IOService ioService;
    private final Localization localization;

    public TestRunner(TestingService testingService, IOService ioService, Localization localization) {
        this.testingService = testingService;
        this.ioService = ioService;
        this.localization = localization;
    }

    public void run(Locale locale) {
        if (locale != null) {
            localization.setLocale(locale);
        }

        ioService.write(localization.getMessage("write.name"));
        String name = ioService.read();

        testingService.showQuestions();

        ioService.write(localization.getMessage(
                "write.result",
                new String[]{name, String.valueOf(testingService.getResult())}));

    }

    public void run() {
        run(null);
    }
}
