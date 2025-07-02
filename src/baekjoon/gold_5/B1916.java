package baekjoon.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class B1916 {
    static int N;
    static int M;
    static ArrayList<int[]>[] edges;
    static boolean[] visited;

    public static int dijkstra(int start, int goal) {
        visited = new boolean[N + 1];
        var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] u = queue.remove();
            int node = u[0];
            int distance = u[1];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            if (node == goal ) {
                return distance;
            }

            for (int[] edge : edges[node]) {
                int neighbor = edge[0];
                int cost = edge[1];
                queue.add(new int[] {neighbor, distance + cost});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new ArrayList[N +1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            edges[a].add(new int[]{b, cost});
        }

        String[] startAndEnd = br.readLine().split(" ");
        int start = Integer.parseInt(startAndEnd[0]);
        int goal = Integer.parseInt(startAndEnd[1]);

        System.out.println(dijkstra(start, goal));
    }
}
