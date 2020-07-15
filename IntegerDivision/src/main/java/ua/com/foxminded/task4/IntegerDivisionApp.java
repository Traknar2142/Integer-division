package ua.com.foxminded.task4;

public class IntegerDivisionApp {
    public static void main(String[] args) {
        int dividend = 3895;
        int divisor = 3;
        String [] dividendStr = String.valueOf(dividend).split("");
        StringBuilder builder = new StringBuilder();
        StringBuilder builderResult = new StringBuilder();
        
        int incopletePrivate = 0;
        int result = 0;
        int surplus = 0;
        int count = 0;
        for (int i = 0; i < dividendStr.length-1; i++) {

            while (incopletePrivate <= divisor) {
                builder.append(dividendStr[count]);
                incopletePrivate = Integer.parseInt(builder.toString());
                count++;
            }            
            incopletePrivate = Integer.parseInt(builder.toString());
            result = incopletePrivate / divisor;
            surplus = incopletePrivate - (result * divisor);
            incopletePrivate = Integer.parseInt(builder.toString());
            builder = new StringBuilder();
            builderResult.append(result);
            builder.append(surplus);
            if (count == dividendStr.length) {
                break;
            }
            builder.append(dividendStr[count]);
            count++;            
        }
        System.out.println(builderResult);
        
    }

}
