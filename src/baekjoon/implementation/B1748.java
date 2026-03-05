package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int count = 0;
        int digits = 1;
        int num = 10;
        for (int i = 1; i <= N; i++) {
            if (i % num == 0) {
                digits++;
                num *= 10;
            }
            count += digits;

        }
        System.out.println(count);
    }
}
