package ua.com.foxminded.task4.integerdivision;

import java.util.*;
import java.util.ArrayList;

public class IntegerDivision {
    private List<String> incompleteQuotients = new ArrayList<String>();

    public String makeDivision(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be 0");
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend < divisor) {
            return "" + dividend + "/" + divisor + "=0";
        }

        String[] digits = String.valueOf(dividend).split("");
        int incompleteQuotientNum = 0;
        int numPointer = 0;
        int numeralOfResult = 0;
        int remainder = 0;
        int product = 0;
        StringBuilder incompleteQuotientForCalculation = new StringBuilder();
        StringBuilder builderResult = new StringBuilder();

        incompleteQuotientForCalculation.append(digits[numPointer]);
        incompleteQuotientNum = Integer.parseInt(incompleteQuotientForCalculation.toString());

        while (incompleteQuotientNum < divisor) {
            numPointer++;
            incompleteQuotientForCalculation.append(digits[numPointer]);
            incompleteQuotientNum = Integer.parseInt(incompleteQuotientForCalculation.toString());
        }

        incompleteQuotients.add(Integer.toString(incompleteQuotientNum));
        numPointer++;

        for (; numPointer <= digits.length; numPointer++) {
            numeralOfResult = incompleteQuotientNum / divisor;
            product = numeralOfResult * divisor;
            incompleteQuotients.add(Integer.toString(product));
            remainder = incompleteQuotientNum - product;
            builderResult.append(numeralOfResult);
            incompleteQuotientForCalculation = new StringBuilder();

            if (remainder != 0) {
                incompleteQuotientForCalculation.append(remainder);
            }
            if (numPointer == digits.length) {
                break;
            }

            incompleteQuotientForCalculation.append(digits[numPointer]);
            incompleteQuotients.add(incompleteQuotientForCalculation.toString());
            incompleteQuotientNum = Integer.parseInt(incompleteQuotientForCalculation.toString());
        }

        if (incompleteQuotients.size() != 1) {
            String penultimateNum = incompleteQuotients.get(incompleteQuotients.size() - 2);
            String lastNum = incompleteQuotients.get(incompleteQuotients.size() - 1);
            int difference = Integer.parseInt(penultimateNum) - Integer.parseInt(lastNum);
            incompleteQuotients.add(Integer.toString(difference));
        } else {
            incompleteQuotients.add(incompleteQuotients.get(0));
        }

        return printDivisionColumn(dividend, divisor, Integer.parseInt(builderResult.toString()));
    }

    private String printDivisionColumn(int dividend, int divisor, int result) {
        StringBuilder spaces = new StringBuilder("");
        StringBuilder hyphens = new StringBuilder("");
        StringBuilder stringResult = new StringBuilder();

        stringResult.append("_" + dividend + "|" + divisor + "\n");

        for (int count = incompleteQuotients.get(0).length(); count < Integer.toString(dividend).length(); count++) {
            spaces.append(" ");
        }

        for (int count = Integer.toString(result).length(); count > 0; count--) {
            hyphens.append("-");
        }

        stringResult.append(" " + incompleteQuotients.get(1) + spaces + "|" + hyphens + "\n");
        hyphens = new StringBuilder();

        for (int count = incompleteQuotients.get(0).length(); count > 0; count--) {
            hyphens.append("-");
        }

        stringResult.append(" " + hyphens + spaces + "|" + result + "\n");

        spaces = new StringBuilder();

        for (int pointer = 2; pointer < incompleteQuotients.size() - 1; pointer = pointer + 2) {
            hyphens = new StringBuilder();
            int minuend = Integer.parseInt(incompleteQuotients.get(pointer - 2));
            int subtrahend = Integer.parseInt(incompleteQuotients.get(pointer - 1));
            spaces.append(calculateSpaces(minuend, subtrahend));
            stringResult.append(spaces + "_" + incompleteQuotients.get(pointer) + "\n");
            stringResult.append(spaces + " " + incompleteQuotients.get(pointer + 1) + "\n");

            for (int count = incompleteQuotients.get(pointer + 1).length(); count > 0; count--) {
                hyphens.append("-");
            }
            stringResult.append(spaces + " " + hyphens + "\n");

            if (pointer >= incompleteQuotients.size() - 1) {
                break;
            }
        }

        int lengthOfPenultimateNum = incompleteQuotients.get(incompleteQuotients.size() - 2).length();
        int lengthOfLastNum = incompleteQuotients.get(incompleteQuotients.size() - 1).length();
        int countOfSpaces = lengthOfPenultimateNum - lengthOfLastNum;

        for (int count = 0; count <= countOfSpaces; count++) {
            spaces.append(" ");
        }
        stringResult.append(spaces + incompleteQuotients.get(incompleteQuotients.size() - 1));

        return stringResult.toString();
    }

    private StringBuilder calculateSpaces(int minuend, int subtrahend) {
        StringBuilder spaces = new StringBuilder();

        int difference = minuend - subtrahend;
        int countOfSpaces = Integer.toString(subtrahend).length() - Integer.toString(difference).length();
        if (difference == 0) {
            spaces.append(" ");
        }

        for (int count = 1; count <= countOfSpaces; count++) {
            spaces.append(" ");
        }

        return spaces;
    }
}


