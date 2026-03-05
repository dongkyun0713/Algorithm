package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15486 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] t = new int[N];
        int[] p = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = N - 1; i >= 0; i--) {
            // 1) 오늘 상담 안함
            dp[i] = dp[i + 1];

            // 2) 오늘 상담 함
            int next = i + t[i];
            if (next <= N) {
                dp[i] = Math.max(dp[i], p[i] + dp[next]);
            }
        }
        System.out.println(dp[0]);

    }
}
