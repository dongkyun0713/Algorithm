package baekjoon.dp;

import java.io.*;
import java.util.*;

public class B1005 {
    static int N, K;
    static int[] time;
    static int[] memo;
    static ArrayList<Integer>[] pre;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N + 1];
            memo = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            pre = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                pre[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                pre[y].add(x);
            }

            int W = Integer.parseInt(br.readLine());

            Arrays.fill(memo, -1);
            sb.append(dfs(W)).append("\n");
        }

        System.out.print(sb);
    }

    static int dfs(int v) {
        if (memo[v] != -1) {
            return memo[v];
        }

        int max = 0;

        for (int p : pre[v]) {
            max = Math.max(max, dfs(p));
        }

        return memo[v] = max + time[v];
    }
}