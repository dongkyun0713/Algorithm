package baekjoon.graph;

import java.io.*;
import java.util.*;

public class B14867 {
    static int a, b, c, d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); // 용량 A
        b = Integer.parseInt(st.nextToken()); // 용량 B
        c = Integer.parseInt(st.nextToken()); // 목표 A
        d = Integer.parseInt(st.nextToken()); // 목표 B

        System.out.println(bfs());
    }

    private static String key(int x, int y) {
        return x + "_" + y;
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        q.add(new int[]{0, 0, 0});
        visited.add(key(0, 0));

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curA = cur[0], curB = cur[1], cnt = cur[2];

            if (curA == c && curB == d) return cnt;

            // 1) Fill A
            push(q, visited, a, curB, cnt);

            // 2) Fill B
            push(q, visited, curA, b, cnt);

            // 3) Empty A
            push(q, visited, 0, curB, cnt);

            // 4) Empty B
            push(q, visited, curA, 0, cnt);

            // 5) Move A -> B
            int moveAB = Math.min(curA, b - curB);
            push(q, visited, curA - moveAB, curB + moveAB, cnt);

            // 6) Move B -> A
            int moveBA = Math.min(curB, a - curA);
            push(q, visited, curA + moveBA, curB - moveBA, cnt);
        }

        return -1;
    }

    private static void push(Queue<int[]> q, Set<String> visited, int na, int nb, int cnt) {
        String k = key(na, nb);
        if (!visited.contains(k)) {
            visited.add(k);
            q.add(new int[]{na, nb, cnt + 1});
        }
    }
}
