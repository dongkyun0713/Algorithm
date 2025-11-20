package baekjoon.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2110 {
    static int N;
    static long M;
    static long[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        long max = 0;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            long house = Long.parseLong(st.nextToken());
            if (house > max) {
                max = house;
            } else {
                min = house;
            }
            houses[i] = house;
        }


    }

}
