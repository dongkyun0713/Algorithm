package baekjoon.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2798_블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String input2[] = br.readLine().split(" ");
        int sum = Integer.parseInt(input2[0]) + Integer.parseInt(input2[1]) +  Integer.parseInt(input2[2]);
        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                for(int k = j+1; k < N; k++) {
                    int a = Integer.parseInt(input2[i]);
                    int b = Integer.parseInt(input2[j]);
                    int c = Integer.parseInt(input2[k]);

                    if(Math.abs(M - sum) > Math.abs(M - a - b - c) && a + b + c <= M) sum = a + b + c;
                }
            }
        }
        System.out.println(sum);
    }
}
