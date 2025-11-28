package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[0] = 1;
        dec[0] = 1;

        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (seq[i] >= seq[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
            if (seq[i] <= seq[i - 1]) {
                dec[i] = dec[i - 1] + 1;
            } else {
                dec[i] = 1;
            }
            answer = Math.max(answer, Math.max(inc[i], dec[i]));
        }

        if (n == 1) {
            System.out.println(1);
        } else {
            System.out.println(answer);
        }
    }
}
