package ru.dsoccer1980.service;

import org.springframework.stereotype.Service;
import ru.dsoccer1980.util.Localization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ioService.write(localization.getMessage("write.name"));
        String name = bufferedReader.readLine();

        testingService.showQuestions();

        ioService.write(localization.getMessage(
                "write.result",
                new String[]{name, String.valueOf(testingService.getResult())}));

    }
}
