package ua.com.foxminded.task4.integerdivision;

import java.util.*;
import java.util.ArrayList;

public class IntegerDivision {
    private List<String> incompleteQuotient = new ArrayList<String>();

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
        int incompletePrivate = 0;
        int numPointer = 0;
        int numeralOfResult = 0;
        int remainder = 0;
        int product = 0;
        StringBuilder incompletePrivateBuilder = new StringBuilder();
        StringBuilder builderResult = new StringBuilder();
        incompletePrivateBuilder.append(digits[numPointer]);
        incompletePrivate = Integer.parseInt(incompletePrivateBuilder.toString());
        while (incompletePrivate < divisor) {
            numPointer++;
            incompletePrivateBuilder.append(digits[numPointer]);
            incompletePrivate = Integer.parseInt(incompletePrivateBuilder.toString());
        }
        incompleteQuotient.add(Integer.toString(incompletePrivate));
        numPointer++;
        for (; numPointer <= digits.length; numPointer++) {
            numeralOfResult = incompletePrivate / divisor;
            product = numeralOfResult * divisor;
            incompleteQuotient.add(Integer.toString(product));
            remainder = incompletePrivate - product;
            builderResult.append(numeralOfResult);
            incompletePrivateBuilder = new StringBuilder();
            if (remainder != 0) {
                incompletePrivateBuilder.append(remainder);
            }
            if (numPointer == digits.length) {
                break;
            }
            incompletePrivateBuilder.append(digits[numPointer]);
            incompleteQuotient.add(incompletePrivateBuilder.toString());
            incompletePrivate = Integer.parseInt(incompletePrivateBuilder.toString());
        }
        if (incompleteQuotient.size() != 1) {
            String penultimateNum = incompleteQuotient.get(incompleteQuotient.size() - 2);
            String lastNum = incompleteQuotient.get(incompleteQuotient.size() - 1);
            int difference = Integer.parseInt(penultimateNum) - Integer.parseInt(lastNum);            
            incompleteQuotient.add(Integer.toString(difference));
        } else {
            incompleteQuotient.add(incompleteQuotient.get(0));
        }
        return printColumn(dividend, divisor, Integer.parseInt(builderResult.toString()));
    }

    private String printColumn(int dividend, int divisor, int result) {
        StringBuilder spaces = new StringBuilder("");
        StringBuilder hyphens = new StringBuilder("");
        StringBuilder stringResult = new StringBuilder();
        stringResult.append("_" + dividend + "|" + divisor + "\n");
        for (int count = incompleteQuotient.get(0).length(); count < Integer.toString(dividend).length(); count++) {
            spaces.append(" ");
        }
        for (int count = Integer.toString(result).length(); count > 0; count--) {
            hyphens.append("-");
        }
        stringResult.append(" " + incompleteQuotient.get(1) + spaces + "|" + hyphens + "\n");
        hyphens = new StringBuilder();
        for (int count = incompleteQuotient.get(0).length(); count > 0; count--) {
            hyphens.append("-");
        }
        stringResult.append(" " + hyphens + spaces + "|" + result + "\n");
        spaces = new StringBuilder();
        int countOfSpaces;
        for (int pointer = 2; pointer < incompleteQuotient.size() - 1; pointer = pointer + 2) {
            int difference = Integer.parseInt(incompleteQuotient.get(pointer - 2))
                    - Integer.parseInt(incompleteQuotient.get(pointer - 1));
            countOfSpaces = incompleteQuotient.get(pointer - 1).length() - Integer.toString(difference).length();
            if (difference == 0) {
                spaces.append(" ");
            }
            for (int count = 1; count <= countOfSpaces; count++) {
                spaces.append(" ");
            }
            hyphens = new StringBuilder();
            stringResult.append(spaces + "_" + incompleteQuotient.get(pointer) + "\n");
            stringResult.append(spaces + " " + incompleteQuotient.get(pointer + 1) + "\n");
            for (int count = incompleteQuotient.get(pointer + 1).length(); count > 0; count--) {
                hyphens.append("-");               
            }
            stringResult.append(spaces + " " + hyphens + "\n");
            if (pointer >= incompleteQuotient.size() - 1) {
                break;
            }
        }
        int lengthOfPenultimateNum = incompleteQuotient.get(incompleteQuotient.size() - 2).length();
        int lengthOfLastNum = incompleteQuotient.get(incompleteQuotient.size() - 1).length();
        countOfSpaces = lengthOfPenultimateNum - lengthOfLastNum;
        for (int count = 0; count <= countOfSpaces; count++) {
            spaces.append(" ");
        }
        stringResult.append(spaces + incompleteQuotient.get(incompleteQuotient.size() - 1));
        return stringResult.toString();
    }
}


