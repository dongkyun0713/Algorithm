package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            stack.push(s.charAt(0));
            if(s.length() % 2 == 1) continue;

            for (int j = 1; j < s.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == s.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(j));
                }
            }
            if (stack.isEmpty()) count++;

        }
        System.out.println(count);
    }
}
