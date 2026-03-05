package baekjoon.graph.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B1446 {
    static int N, D;
    static List<Shortcut> shortcuts;
    static int[] memo;

    static class Shortcut {
        int start, end, cost;

        Shortcut(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (end <= D) {
                shortcuts.add(new Shortcut(start, end, cost));
            }
        }

        memo = new int[D+1];
        Arrays.fill(memo, -1);

        System.out.println(dfs(D));
    }

    private static int dfs(int dist) {
        if (memo[dist] != -1) {
            return memo[dist];
        }
        if (dist <= 0) {
            return 0;
        }
        int case1 = dfs(dist - 1) + 1; // 일반도로
        int case2 = Integer.MAX_VALUE; // 지름길
        for (Shortcut s : shortcuts) {
            int start = s.start;
            int end = s.end;
            int cost = s.cost;
            if (end == dist) {
                case2 = Math.min(case2, dfs(start) + cost);
            }
        }
        return memo[dist] = Math.min(case1, case2);
    }
}
