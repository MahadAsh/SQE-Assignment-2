package com.example.app;

import static org.junit.jupiter.api.Assertions.*;
import com.example.app.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CalculatorParameterizedTest {

    private final Calculator calc = new Calculator();

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/valid_calculator_tests.csv", numLinesToSkip = 1)
    void testValidOperations(double input1, double input2, String operation, double expected) {
        double result;
        switch (operation) {
            case "ADD":
                result = calc.add(input1, input2);
                break;
            case "SUB":
                result = calc.subtract(input1, input2);
                break;
            case "MUL":
                result = calc.multiply(input1, input2);
                break;
            case "DIV":
                result = calc.divide(input1, input2);
                break;
            case "POW":
                result = calc.power(input1, input2);
                break;
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/invalid_calculator_tests.csv", numLinesToSkip = 1)
    void testInvalidOperations(String input1, String input2, String operation, String expected) {
        assertThrows(Exception.class, () -> {
            double a = Double.parseDouble(input1);
            double b = Double.parseDouble(input2);
            switch (operation) {
                case "DIV":
                    calc.divide(a, b);
                    break;
                case "SQRT":
                    calc.sqrt(a);
                    break;
                case "ADD":
                    calc.add(a, b);
                    break;
                case "MUL":
                    calc.multiply(a, b);
                    break;
            }
        });
    }
}
