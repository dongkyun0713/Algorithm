package baekjoon.bronze_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B27433_팩토리얼2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.print(factorial(n));
    }

    public static long factorial(long n) {
        if (n == 0) return 1;
        if (n == 1) return n;
        else return n * factorial(n-1);
    }
}
