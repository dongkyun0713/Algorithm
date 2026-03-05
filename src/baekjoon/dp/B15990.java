package baekjoon.dp;

import java.io.*;

public class B15990 {
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] nums = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i] > max) max = nums[i];
        }

        long[][] dp = new long[max + 1][4];

        if (max >= 1) dp[1][1] = 1;
        if (max >= 2) dp[2][2] = 1;
        if (max >= 3) { dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1; }

        for (int n = 4; n <= max; n++) {
            dp[n][1] = (dp[n-1][2] + dp[n-1][3]) % MOD;
            dp[n][2] = (dp[n-2][1] + dp[n-2][3]) % MOD;
            dp[n][3] = (dp[n-3][1] + dp[n-3][2]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : nums) {
            long ans = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
