package programmers.level_2;

import java.util.*;

public class P76502 {
    static public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            String str = s.substring(i, s.length()) + s.substring(0, i);  // 왼쪽으로 i칸씩 회전
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == ')' && stack.peek() == '(') {  // 닫힌 괄호면 이전 스택이 열린 괄호인지 확인
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "[](){}";

        System.out.println(solution(s));
    }
}
