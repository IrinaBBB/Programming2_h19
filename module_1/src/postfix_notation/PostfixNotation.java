package postfix_notation;

import java.util.ArrayDeque;
import java.util.Deque;


public class PostfixNotation {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: Java PostfixNotation \"Expressions\"");
            System.exit(1);
        }

        try {
            System.out.println(evaluateExpression(args[0]));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + args[0]);
        }

    }


    public static int evaluateExpression(String expression) throws Exception {

        Deque<Integer> operandDeque = new ArrayDeque<>();

        expression = insertBlanks(expression);

        String[] tokens = expression.split(" ");

        for(String token : tokens) {
            if (token.length() == 0)
                continue;
            else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||
                    token.charAt(0) == '/' || token.charAt(0) == '*')
                processAnOperator(operandDeque, token.charAt(0));

            else if (Character.isDigit(token.charAt(0)))
                operandDeque.push(Integer.parseInt(token));

            else
                throw new Exception("Wrong expression");

        }
        return operandDeque.pop();
    }

    public static void processAnOperator(Deque<Integer> operandDeque, char operator) {
        int op1 = operandDeque.pop();
        int op2 = operandDeque.pop();

        switch (operator) {
            case '+': operandDeque.push(op2 + op1); break;
            case '-': operandDeque.push(op2 - op1); break;
            case '/': operandDeque.push(op2 / op1); break;
            case '*': operandDeque.push(op2 * op1);
        }


    }

    public static String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '/' || s.charAt(i) == '*')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }

        return result;
    }
}


