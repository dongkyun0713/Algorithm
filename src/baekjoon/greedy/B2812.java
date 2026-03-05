package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B2812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();

        Deque<Character> stack = new ArrayDeque<>();


        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && K > 0 && stack.peekLast() < arr[i]) {
                stack.removeLast();
                K--;
            }

            stack.addLast(arr[i]);
        }

        while (K > 0) {
            stack.removeLast();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }

        System.out.println(sb);
    }
}
