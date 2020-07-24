package ua.com.foxminded.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import ua.com.foxminded.task4.integerdivision.IntegerDivision;

public class IntegerDivisionApp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String dividend = reader.readLine();
        String divisor = reader.readLine();
        IntegerDivision division = new IntegerDivision();
        if (!StringUtils.isNumericSpace(dividend) || !StringUtils.isNumericSpace(divisor)) {
            throw new IllegalArgumentException("Please enter numbers");
        }
        System.out.println(division.makeDivision(Integer.parseInt(dividend), Integer.parseInt(divisor)));
    }
}
