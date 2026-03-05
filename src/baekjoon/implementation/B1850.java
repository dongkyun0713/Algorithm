package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long g = gcd(a, b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < g; i++) {
            sb.append("1");
        }
        System.out.println(sb);
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

}
