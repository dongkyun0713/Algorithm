package baekjoon.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17504_제리와톰2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        long[] arr = new long[n+1];
        arr[0] = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
        }
        long answer1 = arr[n-1]; // 분자
        long answer2 = arr[n-1] * arr[n-2] + 1; // 분모

        for(int i = n-2; i > 0; i--) {
            answer1 = answer1 + arr[i-1] * answer2  ;
            long tmp = answer1;
            answer1 = answer2;
            answer2 = tmp;

        }
        answer1 = answer2 - answer1;
        System.out.println(answer1 + " " + answer2);
    }
}
