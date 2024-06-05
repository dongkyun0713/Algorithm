package baekjoon.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B13241_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        Long a = Long.parseLong(input[0]);
        Long b = Long.parseLong(input[1]);

        System.out.println(a * b / gcd(a, b));

    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b; // 나머지를 구해준다.

            // GCD(a, b) = GCD(b, r)이므로 변환한다.
            a = b;
            b = r;
        }
        return a;
    }
}
