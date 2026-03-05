package baekjoon.ds;

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
        int[] tops = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> stack = new ArrayDeque<>(); // idx, value
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int top = tops[i];
            while (!stack.isEmpty() && stack.peek()[1] < tops[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) sb.append(0).append(" ");
            else sb.append(stack.peek()[0] + 1).append(" ");


            stack.push(new int[]{i, top});
        }

        System.out.println(sb);
    }
}
