package com.example.app;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test @Tag("fast")
    void reverse_nonNullString_returnsReversed(){ assertEquals("dcba", StringUtils.reverse("abcd")); }

    @Test @Tag("fast")
    void reverse_null_returnsNull(){ assertNull(StringUtils.reverse(null)); }

    @Test @Tag("fast")
    void isPalindrome_simplePalindrome_true(){ assertTrue(StringUtils.isPalindrome("Race car")); }

    @Test @Tag("fast")
    void isPalindrome_nonPalindrome_false(){ assertFalse(StringUtils.isPalindrome("Hello")); }

    @Test @Tag("fast")
    void isPalindrome_null_throws(){ assertThrows(IllegalArgumentException.class, ()->StringUtils.isPalindrome(null)); }

    @ParameterizedTest
    @CsvFileSource(resources="/data/string-valid.csv", numLinesToSkip=1)
    @Tag("data-driven")
    void palindrome_csvDriven(String input, boolean expected){ assertEquals(expected, StringUtils.isPalindrome(input)); }

    @Test @Tag("fast")
    void reverse_emptyString_returnsEmpty() {
        assertEquals("", StringUtils.reverse(""));
    }

    @Test @Tag("fast")
    void isPalindrome_singleChar_returnsTrue() {
        assertTrue(StringUtils.isPalindrome("a"));
    }
}
