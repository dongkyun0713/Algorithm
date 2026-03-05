package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B2910 {
    static class Point {
        int cnt, value;

        public Point(int cnt, int value) {
            this.cnt = cnt;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Point> list = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int k : map.keySet()) {
            list.add(new Point(map.get(k), k));
        }

        list.sort((a, b) -> b.cnt - a.cnt);

        StringBuilder sb = new StringBuilder();
        for (Point p : list) {
            for (int i = 0; i < p.cnt; i++) {
                sb.append(p.value).append(" ");
            }
        }
        System.out.println(sb);
    }
}
