package baekjoon.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1504 {
    static final int INF = 200_000_000;
    static int N, E;
    static List<int[]>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, d});
            edges[b].add(new int[]{a, d});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int w = 0;
        for (int[] edge : edges[v1]) {
            if (edge[0] == v2) {
                w = edge[1];
            }
        }

        int[] distS = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        long path1 = (long)distS[v1] + distV1[v2] + distV2[N]; // 1->v1->v2->N
        long path2 = (long)distS[v2] + distV2[v1] + distV1[N]; // 1->v2->v1->N

        long answer = Math.min(path1, path2);
        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        boolean[] visited = new boolean[N + 1];
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
