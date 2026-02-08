package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11053_2 {
    static int N;
    static int[] seq;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[N];
        Arrays.fill(memo, -1);

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dfs(i));
        }
        System.out.println(max);
    }

    private static int dfs(int idx) {
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int best = 1;
        for (int i = idx - 1; i >= 0; i--) {
            if (seq[idx] > seq[i]) {
                best = Math.max(best, dfs(i) + 1);
            }
        }
        return memo[idx] = best;
    }
}
