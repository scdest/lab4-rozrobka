package com.springbootdev.lab4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.NoSuchElementException;

@RestController
public class ExceptionsController {

    @GetMapping("/throw-exception")
    public void throwException(@RequestParam String exceptionType) throws Exception {
        switch (exceptionType.toUpperCase()) {
            case "IO" -> throw new IOException("IOException occurred");
            case "SQL" -> throw new SQLException("SQLException occurred");
            case "PARSE" -> throw new ParseException("ParseException occurred", 0);
            case "RUNTIME" -> throw new RuntimeException("RuntimeException occurred");
            case "INDEX" -> throw new IndexOutOfBoundsException("IndexOutOfBoundsException occurred");
            default -> throw new Exception("Unknown exception occurred");
        }
    }

    @GetMapping("/any-exception")
    public void throwAnyException() {
        throw new RuntimeException();
    }
}
