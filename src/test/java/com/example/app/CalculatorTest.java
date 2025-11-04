package com.example.app;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calc;

    @BeforeEach
    void setup(){ calc = new Calculator(); }

    @Test @Tag("fast")
    void add_twoPositiveNumbers_returnsSum(){ assertEquals(5, calc.add(2,3)); }

    @Test @Tag("fast")
    void divide_byNonZero_returnsQuotient(){ assertEquals(2.5, calc.divide(5,2), 1e-9); }

    @Test @Tag("fast")
    void divide_byZero_throwsIllegalArgumentException(){ assertThrows(IllegalArgumentException.class, ()->calc.divide(1,0)); }

    @Test @Tag("fast")
    void factorial_zero_returnsOne(){ assertEquals(1, calc.factorial(0)); }

    @Test @Tag("fast")
    void factorial_negative_throws(){ assertThrows(IllegalArgumentException.class, ()->calc.factorial(-1)); }

    @ParameterizedTest
    @CsvFileSource(resources="/data/calculator-valid.csv", numLinesToSkip=1)
    @Tag("data-driven")
    void add_csvDriven(double a, double b, double expected){ assertEquals(expected, calc.add(a,b), 1e-9); }

    @Test @Tag("slow")
    void factorial_maxIntBoundary_throws() {
        assertThrows(ArithmeticException.class, () -> calc.factorial(Integer.MAX_VALUE));
    }

    @Test @Tag("fast")
    void multiply_largeNumbers_returnsProduct() {
        assertEquals(1_000_000.0, calc.multiply(1000, 1000), 1e-9);
    }

    @Test @Tag("fast")
    void divide_smallNonZeroDivisor_returnsQuotient() {
        assertEquals(1e9, calc.divide(1, 1e-9), 1e-9);
    }

    @Test @Tag("fast")
    void factorial_one_returnsOne() {
        assertEquals(1, calc.factorial(1));
    }
}
