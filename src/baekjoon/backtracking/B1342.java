package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1342 {
    static int n;
    static int cnt = 0;
    static boolean[] visited;
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        Arrays.sort(arr);
        n = arr.length;

        visited = new boolean[n];
        dfs(0, new StringBuilder());
        System.out.println(cnt);
    }

    private static void dfs(int depth, StringBuilder sb) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
            if (depth > 0 && sb.charAt(sb.length() - 1) == arr[i]) continue;

            visited[i] = true;
            sb.append(arr[i]);
            dfs(depth + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}