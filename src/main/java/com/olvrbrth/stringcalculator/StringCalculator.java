package com.olvrbrth.stringcalculator;

public class StringCalculator {
    public int Add(String numbers) {
        int sum = 0;
        if (isNoValidNumber(numbers)) {
            return sum;
        }

        String defaultDelimiter = "[,\n]";

        String customDelimiterRegex = "//(.*)\n(.*)";
        if (numbers.matches(customDelimiterRegex)){
            defaultDelimiter = Character.toString(numbers.charAt(2));
            numbers = numbers.substring(4);
        }

        Character last = numbers.charAt(numbers.length() - 1);
        if (last.toString().matches(defaultDelimiter)) {
            throw new IllegalArgumentException();
        }

        String[] split = numbers.split(defaultDelimiter);
        for (int i = 0; i < split.length; i++) {
            sum += Integer.parseInt(split[i]);
        }
        return sum;
    }

    private boolean isNoValidNumber(String numbers) {
        return numbers == null || numbers.isEmpty();
    }
}
