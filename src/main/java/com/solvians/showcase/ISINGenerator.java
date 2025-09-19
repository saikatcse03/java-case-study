package com.solvians.showcase;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ISINGenerator {

    private static final String ALL_ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int CHAR_NUMERIC_START_VAL = 10;
    private static final int CHAR_NUMERIC_START_INDEX = 0;
    private static final int CHAR_NUMERIC_END_INDEX = 1;
    private static final int CHAR_START_VAL = 'A';

    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    public ISINGenerator() {
    }

    public String generateISIN() {
        String randomTwoChars = getRandomString();

        int firstDigit = (randomTwoChars.charAt(CHAR_NUMERIC_START_INDEX) - CHAR_START_VAL) +
                CHAR_NUMERIC_START_VAL;
        int secondDigit = (randomTwoChars.charAt(CHAR_NUMERIC_END_INDEX) - CHAR_START_VAL) +
                CHAR_NUMERIC_START_VAL;

        Long randomNumber = getRandomLong();

        //improve here with math function may be avoid strings
        Long completeNumberPart = Long.parseLong(new StringBuilder()
                .append(firstDigit)
                .append(secondDigit)
                .append(randomNumber)
                .toString());

        int checkDigit = computeCheckDigit(completeNumberPart);

        return new StringBuilder()
                .append(randomTwoChars)
                .append(randomNumber)
                .append(checkDigit)
                .toString();
    }


    private int computeCheckDigit(Long longValue) {
        boolean multiplyByTwo = true;
        int sum = 0;

        while (longValue != 0) {
            int remainder = (int) (longValue % 10);

            if (multiplyByTwo) {
                remainder *= 2;
            }

            sum = sum + (remainder > 9 ? addDigits(remainder) : remainder);
            multiplyByTwo = !multiplyByTwo;

            longValue = longValue/10;
        }

        return ((sum + 9) / 10) * 10 - sum;
    }

    private String getRandomString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            int index = threadLocalRandom.nextInt(ALL_ALPHABETS.length());
            stringBuilder.append(ALL_ALPHABETS.charAt(index));
        }

        return stringBuilder.toString();
    }

    private Long getRandomLong() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            int digit = threadLocalRandom.nextInt(1, 10);
            sb.append(digit);
        }

        return Long.parseLong(sb.toString());
    }

    private int addDigits(int number) {
        return String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
