package level_2;

import java.util.Stack;

public class P12909 {
    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == '(') stack.push('(');
            else stack.pop();
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(())()";
        System.out.println(solution(s));
    }
}
