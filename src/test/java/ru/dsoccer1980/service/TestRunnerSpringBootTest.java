package ru.dsoccer1980.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.dsoccer1980.util.ConfigurableInputStream;


import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@org.springframework.boot.test.context.SpringBootTest
public class TestRunnerSpringBootTest {

    @Autowired
    private TestingService testingService;

    @Autowired
    private Localization localization;

    @Autowired
    private IOService ioService;

    private TestRunner testRunner;
    private ConfigurableInputStream in;
    private ByteArrayOutputStream out;

    @BeforeEach
    public void setup() throws IOException {
        in = new ConfigurableInputStream();

        System.setIn(in);

        testRunner = new TestRunner(testingService, ioService, localization);
    }

    @Test
    public void contexLoads() throws Exception {
        assertThat(testRunner).isNotNull();
        assertThat(testingService).isNotNull();
        assertThat(localization).isNotNull();
        assertThat(ioService).isNotNull();
    }

    @Test
    public void testRunWithRightAnswers() throws IOException {
        in.add("Any Name");
        in.add("A1");
        in.add("A2");

        testRunner.run();

        assertThat(testingService.getResult()).isEqualTo(2);
    }

    @Test
    public void testRunWithWrongAnswers() {
        in.add("Any Name");
        in.add("Wrong");
        in.add("Wrong");
        testRunner.run();
        assertThat(testingService.getResult()).isEqualTo(0);
    }


}

