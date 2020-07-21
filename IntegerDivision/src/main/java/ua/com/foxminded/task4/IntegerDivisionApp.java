package ua.com.foxminded.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ua.com.foxminded.task4.IntegerDivision.IntegerDivision;

public class IntegerDivisionApp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
            String dividend = reader.readLine();
            String divisor = reader.readLine();
            IntegerDivision division = new IntegerDivision();
            try {
                System.out.println(division.makeDivision(Integer.parseInt(dividend), Integer.parseInt(divisor))); 
            } catch (Exception e) {
                System.out.println("ВВедите число");
            }           
    }
}
