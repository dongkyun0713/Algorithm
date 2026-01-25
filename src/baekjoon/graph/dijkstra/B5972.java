package baekjoon.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B5972 {
    static int N, M;
    static List<int[]>[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <=N ; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[a].add(new int[]{b, cost});
            edges[b].add(new int[]{a, cost});
        }
        int[] answer = dijkstra(1);
        System.out.println(answer[N]);
    }

    private static int[] dijkstra(int start) {
        int[] distances = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int node = cur[0];
            int distance = cur[1];
            if (visited[node]) continue;
            visited[node] = true;
            distances[node] = distance;
            for (int[] edge : edges[node]) {
                queue.add(new int[]{edge[0], edge[1] + distance});
            }
        }
        return distances;
    }
}
