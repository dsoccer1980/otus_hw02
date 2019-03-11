package ru.dsoccer1980.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class IOServiceImplTest {

    @Test
    void write() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        IOService ioService = new IOServiceImpl();
        ioService.write("test");
        assertEquals("test\r\n", getData(out));

    }

    private String getData(ByteArrayOutputStream out) {
        try {
            return new String(out.toByteArray(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return e.getMessage();
        }
    }
}