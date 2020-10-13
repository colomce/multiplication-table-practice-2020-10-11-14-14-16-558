package com.tw;

public class MultiplicationTable {
    public String create(int firstNumber, int secondNumber) {
        boolean isValid = isValid(firstNumber, secondNumber);
        String multiplicationTable = buildMultiplicationTable(firstNumber, secondNumber);

        return isValid ? multiplicationTable : null;
    }

    private String buildMultiplicationTable(int firstNumber, int secondNumber) {
        StringBuilder multiplicationTable = new StringBuilder();
        for (int multiplier = firstNumber; multiplier <= secondNumber; multiplier++) {
            for (int multplicand = firstNumber; multplicand <= multiplier; multplicand++) {
                multiplicationTable.append(multplicand)
                        .append("*")
                        .append(multiplier)
                        .append("=")
                        .append(multiplier * multplicand);
                if(multplicand != multiplier) {
                    multiplicationTable.append("  ");
                }
            }
            multiplicationTable.append("\r\n");
        }
        return multiplicationTable.toString().trim();
    }

    private boolean isValid(int firstNumber, int secondNumber) {
        boolean isFirstNumberSmaller = isFirstNumberSmallerOrEqual(firstNumber, secondNumber);
        boolean firstNumberInRange = isInRange(1, 1000, firstNumber);
        boolean secondNumberInRange = isInRange(1, 1000, secondNumber);
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
