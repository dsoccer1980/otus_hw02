package ru.dsoccer1980.service;

import org.springframework.stereotype.Service;
import ru.dsoccer1980.util.exception.NotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class IOServiceImpl implements IOService {

    @Override
    public String read() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    @Override
    public void write(String message) {
        System.out.println(message);

    }
}
