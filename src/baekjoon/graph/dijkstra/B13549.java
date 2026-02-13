package baekjoon.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13549 {
    static int N, K;
    static int MAX_VALUE = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] visited = new boolean[MAX_VALUE + 1];
        pq.add(new int[]{N, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int node = cur[0];
            int time = cur[1];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            if (node == K) {
                return time;
            }
            if (node + 1 <= MAX_VALUE) {
                pq.add(new int[]{node + 1, time + 1});
            }
            if (node - 1 >= 0) {
                pq.add(new int[]{node - 1, time + 1});
            }
            if (node * 2 <= MAX_VALUE) {
                pq.add(new int[]{node * 2, time});
            }
        }
        return -1;
    }
}
