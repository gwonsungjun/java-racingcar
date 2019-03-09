package calculator;

import java.util.Arrays;

public class StringCalculator {
    static int calculate(String calculation){
        if(calculation == null || calculation.equals(""))
            throw new IllegalArgumentException();

        int[] operands = extractOperands(calculation);
        char[] operators = extractOperators(calculation);

        if(operands.length == operators.length-1)
            throw new IllegalStateException();

        int result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            result = calculate2Operands(result, operands[i], operators[i-1]);
        }

        return result;
    }

    private static int calculate2Operands(int i, int j, char operator) {
        if(operator == '+')
            return i + j;
        if(operator == '-')
            return i - j;
        if(operator == '*')
            return i * j;
        if(operator == '/')
            return i / j;

        return 0;
    }

    private static int[] extractOperands(String calculation){
        return Arrays.stream(calculation.split("[+\\-*/]"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static char[] extractOperators(String calculation){
        String[] operators = calculation.split("[0-9]+");

        StringBuilder result = new StringBuilder();
        for (String operator : operators) {
            result.append(operator);
        }

        return result.toString().toCharArray();
    }
}
