package baekjoon.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
    static int N, K;
    static int MAX = 100_000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }

    private static int bfs() {
        boolean[] visited = new boolean[MAX];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{N, 0});
        visited[N] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int node = cur[0];
            int time = cur[1];
            if (node == K) {
                return time;
            }
            if (node - 1 > 0 && !visited[node - 1]) {
                queue.add(new int[]{node - 1, time + 1});
                visited[node - 1] = true;
            }
            if (node + 1 < MAX && !visited[node + 1]) {
                queue.add(new int[]{node + 1, time + 1});
                visited[node + 1] = true;
            }
            if (node * 2 < MAX && !visited[node * 2]) {
                queue.add(new int[]{node * 2, time + 1});
                visited[node * 2] = true;
            }
        }
        return -1;
    }
}
