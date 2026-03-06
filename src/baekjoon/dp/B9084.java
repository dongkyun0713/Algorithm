package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9084 {
    static int N;
    static int[][] memo;
    static int[] coin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            coin = new int[N];
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            memo = new int[N][M+1];
            for (int i = 0; i < N; i++) {
                Arrays.fill(memo[i], -1);
            }

            sb.append(dfs(0, M)).append("\n");
        }
        System.out.print(sb);
    }

    private static int dfs(int idx, int money) {
        if (money == 0) return 1;
        if (money < 0) return 0;
        if (idx == N) return 0;
        if (memo[idx][money] != -1) {
            return memo[idx][money];
        }

        return memo[idx][money] = dfs(idx, money - coin[idx]) + dfs(idx + 1, money);
    }
}
