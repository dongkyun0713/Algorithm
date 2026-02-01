package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236 {
    static int N;
    static int[][] space;
    static int sharkRow;
    static int sharkCol;
    static int sharkSize = 2;
    static int stack = 0;

    // 상좌하우
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static boolean[][] visited;

    static class Node {
        int r, c, d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new int[N][N];
        sharkRow = 0;
        sharkCol = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                space[i][j] = a;
                if (a == 9) {
                    sharkRow = i;
                    sharkCol = j;
                    space[i][j] = 0;
                }
            }
        }
        int time = 0;
        while (true) {
            Node target = bfs();
            if (target == null) break;

            time += target.d;
            sharkRow = target.r;
            sharkCol = target.c;

            space[sharkRow][sharkCol] = 0;
            stack++;

            if (stack == sharkSize) {
                sharkSize++;
                stack = 0;
            }
        }
        System.out.println(time);
    }

    private static Node bfs() {
        visited = new boolean[N][N];
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(sharkRow, sharkCol, 0));
        visited[sharkRow][sharkCol] = true;
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.d != b.d) return a.d - b.d;
                    if (a.r != b.r) return a.r - b.r;
                    return a.c - b.c;
                }
        );
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.d > min) break;

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];
                int nextD = cur.d + 1;

                if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) continue;
                if (visited[nextR][nextC]) continue;
                if (space[nextR][nextC] > sharkSize) continue;
                visited[nextR][nextC] = true;

                if (space[nextR][nextC] != 0 && space[nextR][nextC] < sharkSize) {
                    pq.add(new Node(nextR, nextC, nextD));
                    min = nextD;
                }
                queue.add(new Node(nextR, nextC, nextD));
            }
        }
        return pq.isEmpty() ? null : pq.poll();
    }
}
