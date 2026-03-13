package baekjoon.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2644 {
    static int n;
    static List<Integer>[] family;
    static int m;
    static int x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        family = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            family[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            family[a].add(b);
            family[b].add(a);
        }
        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, 0});
        boolean[] visited = new boolean[n+1];
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int node = cur[0];
            int dist = cur[1];
            if (node == y) return dist;

            for (int next : family[node]) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(new int[]{next, dist + 1});
            }
        }
        return -1;
    }
}
