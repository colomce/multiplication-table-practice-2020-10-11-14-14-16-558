package com.tw;

public class MultiplicationTable {

    private static final int MIN_RANGE = 1;
    private static final int MAXIMUM_RANGE = 1000;

    public String create(int firstNumber, int secondNumber) {
        boolean isValid = isValid(firstNumber, secondNumber);
        String multiplicationTable = buildMultiplicationTable(firstNumber, secondNumber);

        return isValid ? multiplicationTable : null;
    }

    private String buildMultiplicationTable(int firstNumber, int secondNumber) {
        StringBuilder multiplicationTable = new StringBuilder();
        for (int multiplier = firstNumber; multiplier <= secondNumber; multiplier++) {
            for (int multiplicand = firstNumber; multiplicand <= multiplier; multiplicand++) {
                multiplicationTable.append(multiplicand)
                        .append("*")
                        .append(multiplier)
                        .append("=")
                        .append(multiplicand * multiplier);
                if(multiplicand != multiplier) {
                    multiplicationTable.append("  ");
                }
            }
            multiplicationTable.append("\r\n");
        }
        return multiplicationTable.toString().trim();
    }

    private boolean isValid(int firstNumber, int secondNumber) {
        boolean isFirstNumberSmaller = isFirstNumberSmallerOrEqual(firstNumber, secondNumber);
        boolean firstNumberInRange = isInRange(MIN_RANGE, MAXIMUM_RANGE, firstNumber);
        boolean secondNumberInRange = isInRange(MIN_RANGE, MAXIMUM_RANGE, secondNumber);
        boolean allNumbersInRange = firstNumberInRange && secondNumberInRange;

        return isFirstNumberSmaller && allNumbersInRange;
    }

    private boolean isInRange(int min, int max, int number) {
        return number >= min && number <= max;
    }

    private boolean isFirstNumberSmallerOrEqual(int firstNumber, int secondNumber) {
        return firstNumber <= secondNumber;
    }

}
