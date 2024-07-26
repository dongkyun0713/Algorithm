package baekjoon.bronze_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int sum = a+b;
        sb.append(sum);
        System.out.println(sum);
    }
}
