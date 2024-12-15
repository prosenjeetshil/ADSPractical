import java.util.Stack;

public class PostFixEvaluation {

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // If the character is a digit, push it onto the stack
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            }
            // If the character is an operator, pop two operands, apply the operator and push the result
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (c) {
                    case '+': stack.push(operand1 + operand2); break;
                    case '-': stack.push(operand1 - operand2); break;
                    case '*': stack.push(operand1 * operand2); break;
                    case '/': stack.push(operand1 / operand2); break;
                    case '^': stack.push((int) Math.pow(operand1, operand2)); break;
                }
            }
        }

        return stack.pop();  // The final result is the only element left in the stack
    }

    public static void main(String[] args) {
        String postfix = "23*5+";
        System.out.println("Postfix Expression: " + postfix);
        System.out.println("Evaluation Result: " + evaluatePostfix(postfix));
    }
}
