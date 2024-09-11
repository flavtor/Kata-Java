package tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralsTest {
    @Test
    void convertsToRoman() {
        assertEquals("I", RomanNumerals.toRoman(1));
        assertEquals("V", RomanNumerals.toRoman(5));
        assertEquals("X", RomanNumerals.toRoman(10));
    }

    @Test
    void convertsFromRoman() {
        assertEquals(1, RomanNumerals.fromRoman("I"));
        assertEquals(5, RomanNumerals.fromRoman("V"));
        assertEquals(10, RomanNumerals.fromRoman("X"));
    }
    @Test
    void convertsToRomanComplex() {
        assertEquals("IV", RomanNumerals.toRoman(4));
        assertEquals("IX", RomanNumerals.toRoman(9));
        assertEquals("XL", RomanNumerals.toRoman(40));
        assertEquals("XC", RomanNumerals.toRoman(90));
        assertEquals("CD", RomanNumerals.toRoman(400));
        assertEquals("CM", RomanNumerals.toRoman(900));
        assertEquals("MCMLXXXIV", RomanNumerals.toRoman(1984));
    }

    @Test
    void convertsInvalidRoman() {
        assertEquals(-1, RomanNumerals.fromRoman("IIII"));
        assertEquals(-1, RomanNumerals.fromRoman("CCCC"));
        assertEquals(-1, RomanNumerals.fromRoman("MMMM"));
        assertEquals(-1, RomanNumerals.fromRoman("VV"));
    }

    @Test
    void outOfRange() {
        assertEquals("", RomanNumerals.toRoman(0));
        assertEquals("", RomanNumerals.toRoman(-1));
        assertEquals("", RomanNumerals.toRoman(4000));
    }

}
