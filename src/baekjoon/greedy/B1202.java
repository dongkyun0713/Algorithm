package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1202 {
    static class Jewel {
        int m, v;

        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        int[] bags = new int[K];

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (a, b) -> a.m - b.m);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        int idx = 0;

        for (int bag : bags) {
            while (idx < N && jewels[idx].m <= bag) {
                pq.add(jewels[idx].v);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);

    }
}
