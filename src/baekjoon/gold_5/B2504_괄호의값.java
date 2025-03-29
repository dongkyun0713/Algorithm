package baekjoon.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B2504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0;
        int a = 1;  // 임시 값

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(-2); // '('는 -2로 표시
                a *= 2;
            } else if (c == '[') {
                stack.push(-3); // '['는 -3으로 표시
                a *= 3;
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != -2) {
                    System.out.println(0);
                    return;
                }
                stack.pop();

                if (input.charAt(i - 1) == '(') {
                    result += a;
                }
                a /= 2;
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != -3) {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if (input.charAt(i - 1) == '[') {
                    result += a;
                }
                a /= 3;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
