package ua.com.foxminded.task4.IntegerDivision;

import java.util.ArrayList;

public class IntegerDivision {
    ArrayList<String> incompleteQuotient = new ArrayList<>();

    public String makeDivision(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Делитель не может быть 0");
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < divisor) {
            return "" + dividend + "/" + divisor + "=0";
        }        
        String[] dividendStr = String.valueOf(dividend).split("");
        int incompletePrivate = 0;
        int numPointer = 0;
        int numeralOfResult = 0;
        int remainder = 0;
        int product = 0;
        StringBuilder incompletePrivateBuilder = new StringBuilder();
        StringBuilder builderResult = new StringBuilder();
        incompletePrivateBuilder.append(dividendStr[numPointer]);
        incompletePrivate = Integer.parseInt(incompletePrivateBuilder.toString());
        while (incompletePrivate < divisor) {
            numPointer++;
            incompletePrivateBuilder.append(dividendStr[numPointer]);
            incompletePrivate = Integer.parseInt(incompletePrivateBuilder.toString());
        }
        incompleteQuotient.add(Integer.toString(incompletePrivate));
        numPointer++;
        for (; numPointer <= dividendStr.length; numPointer++) {
            numeralOfResult = incompletePrivate / divisor;
            product = numeralOfResult * divisor;
            incompleteQuotient.add(Integer.toString(product));
            remainder = incompletePrivate - product;
            builderResult.append(numeralOfResult);
            incompletePrivateBuilder = new StringBuilder();
            if (remainder != 0) {
                incompletePrivateBuilder.append(remainder);
            }
            if (numPointer == dividendStr.length) {
                break;
            }
            incompletePrivateBuilder.append(dividendStr[numPointer]);
            incompleteQuotient.add(incompletePrivateBuilder.toString());
            incompletePrivate = Integer.parseInt(incompletePrivateBuilder.toString());
        }
        if (incompleteQuotient.size() != 1) {
            incompleteQuotient.add(Integer.toString(Integer.parseInt(incompleteQuotient.get(incompleteQuotient.size() - 2)) - Integer.parseInt(incompleteQuotient.get(incompleteQuotient.size() - 1))));
        } else {
            incompleteQuotient.add(incompleteQuotient.get(0));
        }
        return printDivide(incompleteQuotient, dividend, divisor, Integer.parseInt(builderResult.toString()));
    }

    private String printDivide(ArrayList<String> incompleteQuotient, int dividend, int divisor, int result) {
        StringBuilder spaces = new StringBuilder("");
        StringBuilder hyphens = new StringBuilder("");
        StringBuilder stringRsult = new StringBuilder();
        stringRsult.append("_" + dividend + "|" + divisor + "\n");
        for (int count = incompleteQuotient.get(0).length(); count < Integer.toString(dividend).length(); count++) {
            spaces.append(" ");
        }
        for (int count = Integer.toString(result).length(); count > 0; count--) {
            hyphens.append("-");
        }
        stringRsult.append(" " + incompleteQuotient.get(1) + spaces + "|" + hyphens + "\n");
        hyphens = new StringBuilder();
        for (int count = incompleteQuotient.get(0).length(); count > 0; count--) {
            hyphens.append("-");
        }
        stringRsult.append(" " + hyphens + spaces + "|" + result + "\n");
        spaces = new StringBuilder();
        int countOfSpaces;
        int difference;
        for (int pointer = 2; pointer < incompleteQuotient.size() - 1; pointer = pointer + 2) {
            difference = Integer.parseInt(incompleteQuotient.get(pointer - 2))
                    - Integer.parseInt(incompleteQuotient.get(pointer - 1));
            countOfSpaces = incompleteQuotient.get(pointer - 1).length() - Integer.toString(difference).length();
            if (difference == 0) {
                spaces.append(" ");
            }
            for (int count = 1; count <= countOfSpaces; count++) {
                spaces.append(" ");
            }
            hyphens = new StringBuilder();
            stringRsult.append(spaces + "_" + incompleteQuotient.get(pointer) + "\n");
            stringRsult.append(spaces + " " + incompleteQuotient.get(pointer + 1) + "\n");
            for (int count = incompleteQuotient.get(pointer + 1).length(); count > 0; count--) {
                hyphens.append("-");;
            }
            stringRsult.append(spaces + " " + hyphens + "\n");
            if (pointer >= incompleteQuotient.size() - 1) {
                break;
            }
        }
        countOfSpaces = incompleteQuotient.get(incompleteQuotient.size() - 2).length()
                - incompleteQuotient.get(incompleteQuotient.size() - 1).length();
        for (int count = 0; count <= countOfSpaces; count++) {
            spaces.append(" ");
        }
        stringRsult.append(spaces + incompleteQuotient.get(incompleteQuotient.size() - 1));
        return stringRsult.toString();
    }
}


