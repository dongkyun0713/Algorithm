package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463_top_down {
    static int[] memo;
    static int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        memo = new int[X + 1];
        System.out.println(dfs(X));
    }

    static int dfs(int x) {
        if (x == 1) {
            return 0;
        }
        if (memo[x] != 0) {
            return memo[x];
        }

        int a = MAX;
        int b = MAX;

        if (x % 3 == 0) {
            a = dfs(x / 3);
        }

        if (x % 2 == 0) {
            b = dfs(x / 2);
        }

        int c = dfs(x - 1);

        return memo[x] = Math.min(a, Math.min(b, c)) + 1;
    }
}
