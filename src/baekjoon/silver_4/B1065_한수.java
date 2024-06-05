package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1065_한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        if (n < 100) count = n;
        else if (n < 111) {
            count = 99;
        }
        else {
            count = 99;
            for(int i = 111; i <= n; i++) {
                int hundredsPlace = i / 100;
                int tensPlace = i % 100 / 10;
                int onesPlace = i % 10;

                int a = tensPlace - hundredsPlace;
                int b = onesPlace - tensPlace;
                if (a == b) count++;
            }
        }
        System.out.println(count);
    }
}
