package postfix_notation;

import java.util.Stack;

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

        Stack<Integer> operandStack = new Stack<>();

        expression = insertBlanks(expression);

        String[] tokens = expression.split(" ");

        for(String token : tokens) {
            if (token.length() == 0)
                continue;
            else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||
                    token.charAt(0) == '/' || token.charAt(0) == '*')
                processAnOperator(operandStack, token.charAt(0));

            else if (Character.isDigit(token.charAt(0)))
                operandStack.push(Integer.parseInt(token));

            else
                throw new Exception("Wrong expression");

        }
        return operandStack.pop();
    }

    public static void processAnOperator(Stack<Integer> operandStack, char operator) {
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();

        switch (operator) {
            case '+': operandStack.push(op2 + op1); break;
            case '-': operandStack.push(op2 - op1); break;
            case '/': operandStack.push(op2 / op1); break;
            case '*': operandStack.push(op2 * op1);
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


