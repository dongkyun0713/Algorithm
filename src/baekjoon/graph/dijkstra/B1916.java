package baekjoon.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1916 {
    static int N, M;
    static List<int[]>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, cost});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(start, goal));
    }

    private static int dijkstra(int start, int goal) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int node = cur[0], distance = cur[1];
            if (visited[node]) continue;
            visited[node] = true;
            if (node == goal) return distance;
            for (int[] edge : edges[node]) {
                queue.add(new int[]{edge[0], edge[1] + distance});
            }
        }
        return -1;
    }
}
