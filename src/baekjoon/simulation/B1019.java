package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] pages = new int[10];

        for (int i = 1; i <= N; i*=10) {
            int left = N / (i * 10);
            int cur = (N / i) % 10;
            int right = N % i;

            for (int j = 1; j <= 9; j++) {
                pages[j] += left * i;
                if (cur > j) pages[j] += i;
                else if (cur == j) pages[j] += (right + 1);
            }

            if (left == 0) continue;
            pages[0] += (left - 1) * i;
            if (cur > 0) pages[0] += i;
            else if (cur == 0) pages[0] += (right + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(pages[i]).append(" ");
        }
        System.out.println(sb);
    }
}
