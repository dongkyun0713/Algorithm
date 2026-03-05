package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B5568 {
    static int n, k;
    static int[] arr;
    static Set<String> set;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        set = new HashSet<>();
        visited = new boolean[n];
        dfs(0, new StringBuilder());
        System.out.println(set.size());
    }

    private static void dfs(int depth, StringBuilder sb) {
        if (depth == k) {
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;

            int len = sb.length();
            dfs(depth + 1, sb.append(arr[i]));
            visited[i] = false;
            sb.setLength(len);
        }
    }
}
