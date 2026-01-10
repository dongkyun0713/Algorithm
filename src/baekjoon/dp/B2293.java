package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2293 {
    static List<Integer> coins;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        coins = new ArrayList<>();
        memo = new int[k + 1];
        Arrays.fill(memo, -1);

        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(coins);

        memo[0] = 1;
        System.out.println(dfs(k));
    }

    private static int dfs(int k) {

        if (memo[k] != -1) {
            return memo[k];
        }
        int count = 0;

        for (int i = 0; i < coins.indexOf(k); i++) {
            count += dfs(k - coins.get(i)) + 1;
        }
        return memo[k] = count;
    }
}
