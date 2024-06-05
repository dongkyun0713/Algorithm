package baekjoon.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1449_수리공항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        String input2[] = br.readLine().split(" ");
        int arr[] = new int[N];
        if(L == 1) System.out.println(N);
        else {
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input2[i]);
            }
            Arrays.sort(arr);
            double tape = arr[0] - 0.5;
            int count = 1;
            for (int i = 0; i < N; i++) {
                if(tape + L < arr[i]) {
                    count++;
                    tape = arr[i] - 0.5;
                }
            }
            System.out.println(count);
        }
    }
}
//4 2
//1 2 100 101