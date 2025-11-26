package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17404 {
    static final int INF = 1_000_000_000 + 10;

    static int[][] memo;
    static int[][] rgb;
    static int lastColor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1][3];
        rgb = new int[n+1][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = INF;
        for (lastColor = 0; lastColor < 3; lastColor++) {
            for (int i = 0; i <= n; i++) {
                Arrays.fill(memo[i], -1);
            }
            answer = Math.min(answer, dfs(n-1, lastColor));

        }

        System.out.println(answer);
    }


    // i번 집을 컬러로 칠할 떄의 최소 비용, color = 0 or 1 or 2
    private static int dfs(int i, int color) {
        if (i == 0) {
            if (color == lastColor) {
                return INF;
            }
            return rgb[0][color];
        }

        if (memo[i][color] != -1) {
            return memo[i][color];
        }

        int result = 0;

        if (color == 0) {
            result = Math.min(dfs(i - 1, 1), dfs(i - 1, 2)) + rgb[i][color];
        } else if (color == 1) {
            result = Math.min(dfs(i - 1, 0), dfs(i - 1, 2)) + rgb[i][color];
        } else if (color == 2) {
            result = Math.min(dfs(i - 1, 0), dfs(i - 1, 1)) + rgb[i][color];
        }

        return memo[i][color] = result;
    }
}
