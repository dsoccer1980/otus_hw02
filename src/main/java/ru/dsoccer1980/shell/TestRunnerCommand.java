package ru.dsoccer1980.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.dsoccer1980.service.TestRunner;

import java.util.Locale;

@ShellComponent
public class TestRunnerCommand {

    private final TestRunner testRunner;

    @Autowired
    public TestRunnerCommand(TestRunner testRunner) {
        this.testRunner = testRunner;
    }

    @ShellMethod("Test runner")
    public void run(
            @ShellOption(defaultValue = "en") String locale
    ) {
        // invoke service

        testRunner.run(new Locale(locale));
    }

}
