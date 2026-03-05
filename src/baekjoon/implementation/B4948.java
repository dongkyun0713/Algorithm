package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B4948 {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        isPrime = new boolean[123456 * 2 + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            sieve(2 * n);
            int cnt = 0;
            for (int i = n+1; i <= 2*n; i++) {
                if (isPrime[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }


    private static void sieve(int n) {
        for (int i = 2; i * i <= n ; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
