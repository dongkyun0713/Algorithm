package baekjoon.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B18532 {
    static int N, M, K, X;
    static ArrayList<Integer>[] neighbors;

    private static List<Integer> bfs() {
        var result = new ArrayList<Integer>();
        var visited = new boolean[N + 1];
        var queue = new ArrayDeque<int[]>();

        queue.add(new int[]{X, 0});

        while (queue.size() > 0) {
            var u = queue.remove();
            int node = u[0], distance = u[1];

            if (visited[node]) {
                continue;
            }
            visited[node] = true;

            if (distance == K) {
                result.add(node);
            } else if (distance > K) {
                break;
            }

            for (int neighbor : neighbors[node]) {
                queue.add(new int[]{neighbor, distance + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        neighbors = new ArrayList[N + 1];

        for (int i = 1; i <= N; ++i) {
            neighbors[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            neighbors[a].add(b);
        }
        List<Integer> result = bfs();
        if (result.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            System.out.println(result.toString()
                    .replaceAll("[^0-9 ]", "")
                    .replaceAll(" ", "\n")
            );
        }
    }
}
