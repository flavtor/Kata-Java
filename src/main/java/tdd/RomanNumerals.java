package tdd;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Utility class for converting between Roman numerals and integers.
 */
public class RomanNumerals {
    // LinkedHashMap to maintain the order of entries
    private static final LinkedHashMap<String, Integer> romanMap = new LinkedHashMap<>();
    static {
        romanMap.put("M", 1000);
        romanMap.put("CM", 900);
        romanMap.put("D", 500);
        romanMap.put("CD", 400);
        romanMap.put("C", 100);
        romanMap.put("XC", 90);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);
    }

    /**
     * Converts an integer to a Roman numeral.
     *
     * @param number the integer to convert
     * @return the Roman numeral as a String
     */
    public static String toRoman(int number) {
        if (number <= 0 || number > 3000) {
            return ""; // Return an empty string for out of range values
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : romanMap.entrySet()) {
            while (number >= entry.getValue()) {
                result.append(entry.getKey());
                number -= entry.getValue();
            }
        }
        return result.toString();
    }

    /**
     * Converts a Roman numeral to an integer.
     *
     * @param roman the Roman numeral string to convert
     * @return the equivalent integer
     */
    public static int fromRoman(String roman) {
        int result = 0;
        int prev = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            int curr = value(roman.charAt(i));
            if (curr < 0) return -1; // Return -1 for invalid characters
            if (curr >= prev) {
                result += curr;
            } else {
                result -= curr;
            }
            prev = curr;
        }
        return result;
    }

    /**
     * Returns the integer value of a Roman numeral character.
     *
     * @param r the Roman numeral character
     * @return the integer value or -1 if the character is not a valid Roman numeral
     */
    private static int value(char r) {
        switch (r) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1; // Return -1 for any non-Roman numeral character
        }
    }
}
