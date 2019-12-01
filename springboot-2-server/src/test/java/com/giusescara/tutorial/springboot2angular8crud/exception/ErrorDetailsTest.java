package com.giusescara.tutorial.springboot2angular8crud.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ErrorDetailsTest {

    private ErrorDetails errorDetails;

    @BeforeEach
    void setUp() {
        errorDetails = new ErrorDetails(new Date(), "Message", "Details");
    }

    @Test
    void getTimestamp() {
        assertNotNull(errorDetails.getTimestamp(), "The date should not be null");
    }

    @Test
    void getMessage() {
        assertNotNull(errorDetails.getMessage(), "The message should not be null");
    }

    @Test
    void getDetails() {
        assertNotNull(errorDetails.getDetails(), "The details should not be null");
    }

    @AfterEach
    void tearDown() {
        errorDetails = null;
    }
}