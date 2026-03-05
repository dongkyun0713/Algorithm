package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1912 {
    static int n;
    static int[] arr;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[n];
        Arrays.fill(memo, -1001);
        memo[0] = arr[0];

        dfs(n - 1);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, memo[i]);
        }
        System.out.println(max);

    }

    private static int dfs(int idx) {
        if (memo[idx] != -1001) {
            return memo[idx];
        }
        return memo[idx] = Math.max(dfs(idx - 1) + arr[idx], arr[idx]);
    }
}
