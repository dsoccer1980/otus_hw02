package ru.dsoccer1980.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dsoccer1980.util.Localization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class RunTesting {

    private TestingService testingService;
    private IOService ioService;
    private Localization localization;

    @Autowired
    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public RunTesting(TestingService testingService, IOService ioService) {
        this.testingService = testingService;
        this.ioService = ioService;
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
