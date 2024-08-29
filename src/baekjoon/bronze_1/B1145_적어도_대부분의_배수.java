package baekjoon.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1145_적어도_대부분의_배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int answer = 1;

        while (true) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (answer % arr[i] == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                break;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
