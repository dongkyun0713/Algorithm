package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16234 {
    static int N, L, R;
    static int[][] rand;
    static boolean[][] visited;

    // 상, 우, 하, 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node {
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        rand = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rand[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean move = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    List<Node> union = bfs(i, j);
                    if (union.size() >= 2) move = true;
                    int all = 0;
                    for (Node value : union) {
                        all += rand[value.r][value.c];
                    }
                    int dis = all / union.size();
                    for (Node node : union) {
                        rand[node.r][node.c] = dis;
                    }
                }
            }
            if (!move) break;
            day++;
        }
        System.out.println(day);
    }

    private static List<Node> bfs(int r, int c) {
        List<Node> union = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        Node start = new Node(r, c);
        queue.add(start);
        union.add(start);
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            int cPeople = rand[cur.r][cur.c];

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N || visited[nextR][nextC]) continue;
                int nPeople = rand[nextR][nextC];
                int diff = Math.abs(nPeople - cPeople);
                if (diff >= L && diff <= R) {
                    Node node = new Node(nextR, nextC);
                    union.add(node);
                    queue.add(node);
                    visited[nextR][nextC] = true;
                }
            }
        }
        return union;
    }
}
