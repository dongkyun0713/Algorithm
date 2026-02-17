package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class B1327 {
    static int N, K;
    static int[] arr;
    static int[] sortArr;
    static String target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sortArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
           int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            sortArr[i] = n;
        }

        Arrays.sort(sortArr);
        target = encode(sortArr);

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(new Point(encode(arr), 0));
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            String s = cur.s;
            int cnt = cur.cnt;
            if (s.equals(target)) {
                return cnt;
            }
            if (visited.contains(s)) continue;
            visited.add(s);

            int[] curArr = decode(s);
            for (int i = 0; i <= N - K; i++) {
                int[] nextArr = curArr.clone();
                reverse(nextArr, i, i + K - 1);
                String next = encode(nextArr);
                if (!visited.contains(next)) {
                    queue.add(new Point(next, cnt+1));
                }
            }
        }

        return -1;
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            l++;
            r--;
        }
    }



    private static String encode(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private static int[] decode(String s) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return arr;
    }
    private static class Point {
        String s;
        int cnt;

        public Point(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }
}
