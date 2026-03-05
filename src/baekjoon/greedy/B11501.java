package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] prices = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                prices[j] = Long.parseLong(st.nextToken());
            }

            long max = 0;
            long profit = 0;

            for (int j = N - 1; j >= 0 ; j--) {
                long price = prices[j];
                if (price > max) {
                    max = price;
                } else {
                    profit += max - price;
                }
            }

            sb.append(profit).append("\n");
        }
        System.out.print(sb);
    }
}
