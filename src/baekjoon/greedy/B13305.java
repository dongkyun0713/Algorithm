package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long[] gas = new long[N];

        for (int i = 0; i < N; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }

        long min = Integer.MAX_VALUE;
        long answer = 0;
        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min, gas[i]);
            answer += min * dist[i];
        }
        System.out.println(answer);
    }
}
