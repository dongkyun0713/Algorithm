package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2565 {
    static int N;
    static ElectricLine[] lines;
    static int[] memo;

    static class ElectricLine {
        int start, end;

        public ElectricLine(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lines = new ElectricLine[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines[i] = new ElectricLine(start, end);
        }

        Arrays.sort(lines, (a, b) -> a.start - b.start);
        memo = new int[N];
        Arrays.fill(memo, -1);

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dfs(i));
        }
        System.out.println(N - max);
    }

    private static int dfs(int idx) {
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int best = 1;
        for (int i = 0; i < idx; i++) {
            if (lines[i].end < lines[idx].end) {
                best = Math.max(best, dfs(i) + 1);
            }
        }
        return memo[idx] = best;
    }
}
