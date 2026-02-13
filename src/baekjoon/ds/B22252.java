package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B22252 {
    static int Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();

        long answer = 0;
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 1) {
                String name = st.nextToken();
                int k = Integer.parseInt(st.nextToken());
                for (int j = 0; j < k; j++) {
                    map.computeIfAbsent(name, key -> new PriorityQueue<>(Comparator.reverseOrder())).add(Integer.parseInt(st.nextToken()));
                }
            } else if (n == 2) {
                String name = st.nextToken();
                int cnt = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> pq = map.get(name);
                if (pq == null) continue;

                int take = Math.min(cnt, pq.size());
                for (int j = 0; j < take; j++) {
                    answer += pq.poll();
                }
            }
        }
        System.out.println(answer);
    }
}
