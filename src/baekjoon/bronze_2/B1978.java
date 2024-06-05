package baekjoon.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        int count = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(input[i]);
            if (a == 1) continue;
            if(a == 2) {
                count++;
                continue;
            }
            for (int j = 2; j < a; j++) {
                if (a % j == 0) break;
                if (j == a - 1) count++;
            }
        }
        System.out.println(count);
    }
}