import java.util.Stack;

public class ParenthesisBalancing {

    // Method to check if the parentheses are balanced
    public static boolean areParenthesesBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If it's an opening parenthesis, push it to the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If it's a closing parenthesis, check for matching opening parenthesis
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty, all parentheses are balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression = "{[()]}";
        System.out.println("Expression: " + expression);
        System.out.println("Is Balanced: " + areParenthesesBalanced(expression));
        
        expression = "{[(])}";
        System.out.println("Expression: " + expression);
        System.out.println("Is Balanced: " + areParenthesesBalanced(expression));
    }
}
