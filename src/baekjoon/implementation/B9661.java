package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9661 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if (N % 5 == 2 || N % 5 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
