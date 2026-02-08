package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16938 {
    static int N, L, R, X;
    static int[] A;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(answer);
    }

    private static void dfs(int index, int count, int sum, int min, int max) {
        if (sum > R) return;
        if (count + (N - index) < 2) return;

        if (index == N) {
            if (count >= 2 && sum >= L && sum <= R && max - min >= X) {
                answer++;
            }
            return;
        }

        dfs(index + 1, count + 1, sum + A[index], Math.min(min, A[index]), Math.max(max, A[index]));
        dfs(index + 1, count, sum, min, max);

    }
}
