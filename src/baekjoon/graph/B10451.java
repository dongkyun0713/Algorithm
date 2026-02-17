package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10451 {
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N + 1];
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    dfs(j);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int idx) {
        if (!visited[arr[idx]]) {
            visited[arr[idx]] = true;
            dfs(arr[idx]);
        }
    }
}
