package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9251 {
    static String a, b;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();

        memo = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(dfs(a.length() - 1, b.length() - 1));
    }

    private static int dfs(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int result;
        if (a.charAt(i) == b.charAt(j)) {
            result = dfs(i - 1, j - 1) + 1;
        } else {
            result = Math.max(dfs(i - 1, j), dfs(i, j - 1));
        }

        return memo[i][j] = result;
    }
}
