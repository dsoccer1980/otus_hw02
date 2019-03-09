package ru.dsoccer1980.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class TestRunnerTest {

    @Test
    void run() throws IOException {
        TestingService testingService = mock(TestingService.class);
        IOService ioService = mock(IOService.class);
        Localization localization = mock(Localization.class);

        when(ioService.read()).thenReturn("Denis");
        TestRunner testRunner = new TestRunner(testingService, ioService, localization);
        testRunner.run();
        verify(testingService).showQuestions();
    }
}