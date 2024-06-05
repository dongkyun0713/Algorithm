package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class B4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            bw.write(isValid(s) ? "yes" : "no");
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> table = new HashMap<>() {
            {
                put(')', '(');
                put(']', '[');
            }
        };

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[') {
                stack.push(current);
            } else if (current == ')' || current == ']') {
                if (stack.isEmpty() || stack.pop() != table.get(current)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
