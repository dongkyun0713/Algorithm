package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B9465 {
    static int[][] memo;
    static int[][] stickers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            memo = new int[3][n + 1];
            for (int r = 1; r <= 2; r++) {
                Arrays.fill(memo[r], -1);
            }
            stickers = new int[3][n + 1];
            for (int j = 1; j <= 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            memo[1][1] = stickers[1][1];
            memo[2][1] = stickers[2][1];

            sb.append(Math.max(dfs(1, n), dfs(2, n))).append("\n");
        }
        System.out.print(sb);
    }

    private static int dfs(int row, int col) {
        if (col <= 0) {
            return 0;
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        int other = (row == 1) ? 2 : 1;

        int result = Math.max(dfs(other, col - 1), dfs(other, col-2)) + stickers[row][col];

        return memo[row][col] = result;
    }
}
