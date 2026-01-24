package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tops = new int[N];
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> stack = new ArrayDeque<>();  // 인덱스, 탑 높이
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int top = tops[i];

            while (!stack.isEmpty() && stack.peek()[1] < top) {
                stack.pop();
            }

            if (stack.isEmpty()) sb.append("0 ");
            else sb.append(stack.peek()[0] + 1).append(" ");

            stack.push(new int[]{i, top});
        }

        System.out.print(sb);
    }
}
