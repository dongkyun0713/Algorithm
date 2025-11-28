package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2240 {
    static int[][][] memo;
    static int[] plum;
    static int w;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        memo = new int[t + 1][3][w + 1];
        plum = new int[t + 1];

        for (int i = 1; i <= t; i++) {
            plum[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= t; i++) {
            for (int j = 1; j < 3; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        System.out.println(dfs(t, 1, 0));
    }

    private static int dfs(int t, int current, int k) {
        if (t == 0) {
            return 0;
        }

        if (memo[t][current][k] != -1) {
            return memo[t][current][k];
        }

        int moving = (current == 1) ? 2 : 1;

        int result = 0;

        if (k < w) {
            if (current == plum[t]) {
                result = dfs(t - 1, current, k) + 1;
            } else {
                int eat = dfs(t - 1, moving, k + 1) + 1;
                int notEat = dfs(t - 1, current, k);
                result = Math.max(eat, notEat);
            }
        } else {
            if (current == plum[t]) {
                result = dfs(t - 1, current, k) + 1;
            }
            else {
                result = dfs(t - 1, current, k);
            }
        }

        return memo[t][current][k] = result;
    }
}
