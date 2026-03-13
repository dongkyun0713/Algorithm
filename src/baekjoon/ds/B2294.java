package baekjoon.ds;

import java.io.*;
import java.util.*;

public class B2294 {

    static int n, k;
    static int[] coins;
    static int[] memo;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        memo = new int[k + 1];
        Arrays.fill(memo, -1);

        int result = dfs(k);

        if (result == INF) System.out.println(-1);
        else System.out.println(result);
    }

    static int dfs(int money) {

        if (money == 0) return 0;
        if (money < 0) return INF;

        if (memo[money] != -1) return memo[money];

        int result = INF;

        for (int coin : coins) {
            result = Math.min(result, dfs(money - coin) + 1);
        }

        return memo[money] = result;
    }
}
