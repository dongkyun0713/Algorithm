package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2485_가로수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int intervalGcd = 0;

        for (int i = 0; i < n - 1; i++) {
            int distance = arr[i + 1] - arr[i];
            intervalGcd = gcd(distance, intervalGcd);
        }

        System.out.println((arr[n - 1] - arr[0]) / intervalGcd - n + 1);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
