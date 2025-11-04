package com.example.app;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@Tag("slow")
public class CalculatorSlowTest {
    Calculator calc;

    @BeforeEach
    void setup() { calc = new Calculator(); }

    @Test
    void factorial_largeNumber_returnsCorrectValue() {
        assertEquals(2432902008176640000L, calc.factorial(20));
    }

    @Test
    void divide_stressTest_multipleDivisions() {
        for (int i = 1; i <= 1000; i++) {
            assertEquals(1.0, calc.divide(i, i), 1e-9);
        }
    }
}
