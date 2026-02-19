package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class B14867 {
    static int a, b, c, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{0, 0, 0});
        visited.add(getString(0, 0));

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int curA = cur[0];
            int curB = cur[1];
            int cnt = cur[2];
            if (curA == c && curB == d) {
                return cnt;
            }

            // F(a)
            push(queue, visited, a, curB, cnt);

            // F(b)
            push(queue, visited, curA, b, cnt);

            // E(a)
            push(queue, visited, 0, curB, cnt);

            // E(b)
            push(queue, visited, curA, 0, cnt);

            // M(a,b)
            int moveAB = Math.min(curA, b - curB);
            push(queue, visited, curA - moveAB, curB + moveAB, cnt);

            // M(b,a)
            int moveBA = Math.min(curB, a - curA);
            push(queue, visited, curA + moveBA, curB - moveBA, cnt);
        }
        return -1;
    }

    private static String getString(int a, int b) {
        return a + "_" + b;
    }

    private static void push(Queue<int[]> queue, Set<String> visited, int na, int nb, int cnt) {
        String key = getString(na, nb);
        if (!visited.contains(key)) {
            visited.add(key);
            queue.add(new int[]{na, nb, cnt + 1});
        }
    }
}
