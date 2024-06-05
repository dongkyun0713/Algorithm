package baekjoon.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2355_시그마 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);

        long first = 0;
        long last = 0;
        if(a > b) {
            first = b;
            last = a;
        }
        else {
            first = a;
            last = b;
        }

        long answer = (last-first+1) * (first + last) / 2;
        System.out.println(answer);
    }
}
