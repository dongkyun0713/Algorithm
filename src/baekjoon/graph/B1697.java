package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
    static final int MAX = 100_000;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[MAX + 1];
        Arrays.fill(arr, -1);

        System.out.println(bfs(N, K));
    }

    private static int bfs(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        arr[n] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.remove();

            if (cur == k) return arr[cur];

            int next1 = cur - 1;
            int next2 = cur + 1;
            int next3 = cur * 2;

            if (next1 >= 0 && arr[next1] == -1) {
                arr[next1] = arr[cur] + 1;
                queue.add(next1);
            }
            if (next2 <= MAX && arr[next2] == -1) {
                arr[next2] = arr[cur]  + 1;
                queue.add(next2);
            }
            if (next3 <= MAX && arr[next3] == -1) {
                arr[next3] = arr[cur] + 1;
                queue.add(next3);
            }
        }
        return -1;
    }
}
