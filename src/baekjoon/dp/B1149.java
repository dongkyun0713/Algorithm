package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1149 {
    static final int INF = Integer.MAX_VALUE;

    static int[][] memo;
    static int[][] rgb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1][3];
        rgb = new int[n + 1][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;
        for (int color = 0; color < 3; color++) {
            for (int i = 0; i <= n; i++) {
                Arrays.fill(memo[i], -1);
            }
            answer = Math.min(answer, dfs(n - 1, color));
        }

        System.out.println(answer);

    }

    private static int dfs(int i, int color) {
        if (i == 0) {
            return rgb[0][color];
        }

        if (memo[i][color] != -1) {
            return memo[i][color];
        }

        int result = 0;

        if (color == 0) {
            result = Math.min(dfs(i - 1, 1), dfs(i - 1, 2));
        } else if (color == 1) {
            result = Math.min(dfs(i - 1, 0), dfs(i - 1, 2));
        } else if (color == 2) {
            result = Math.min(dfs(i - 1, 0), dfs(i - 1, 1));
        }

        return memo[i][color] = result + rgb[i][color];
    }
}
