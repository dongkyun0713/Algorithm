package baekjoon.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B9370 {
    static final int INF = 1_000_000_000;

    static int n, m, t;
    static int s, g, h;
    static List<int[]>[] edges;
    static int[] dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            edges = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                edges[i] = new ArrayList<>();
            }

            int w = 0;

            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if (a == g && b == h || a == h && b == g) {
                    w = d;
                }
                edges[a].add(new int[]{b, d});
                edges[b].add(new int[]{a, d});
            }

            dest = new int[t];
            int[] distS = dijkstra(s);
            int[] distG = dijkstra(g);
            int[] distH = dijkstra(h);

            ArrayList<Integer> ans = new ArrayList<>();

            for (int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());
                if (distS[x] >= INF) continue;
                int path1 = distS[g] + w + distH[x];
                int path2 = distS[h] + w + distG[x];

                if (path1 == distS[x] || path2 == distS[x]) {
                    ans.add(x);
                }
            }
            Collections.sort(ans);
            for (int a : ans) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        boolean[] visited = new boolean[n + 1];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int node = cur[0];
            int distance = cur[1];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;

            dist[node] = distance;
            for (int[] edge : edges[node]) {
                int next = edge[0];
                int cost = edge[1];
                pq.add(new int[]{next, distance + cost});
            }
        }
        return dist;
    }
}
