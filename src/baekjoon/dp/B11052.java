package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11052 {
    static int[] memo;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];
        price = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(n));
    }

    private static int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dfs(n - i) + price[i]);
        }
        return memo[n] = max;
    }
}
