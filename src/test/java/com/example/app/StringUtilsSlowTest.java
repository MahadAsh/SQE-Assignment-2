package com.example.app;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@Tag("slow")
public class StringUtilsSlowTest {
    @Test
    void reverse_largeString_returnsReversed() {
        String large = "a".repeat(10000);
        String expected = "a".repeat(10000);
        assertEquals(expected, StringUtils.reverse(large));
    }

    @Test
    void isPalindrome_largePalindrome_returnsTrue() {
        String large = "a".repeat(5000) + "b" + "a".repeat(5000);
        assertTrue(StringUtils.isPalindrome(large));
    }
}
