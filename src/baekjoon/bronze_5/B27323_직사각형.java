package baekjoon.bronze_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B27323_직사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        System.out.println(A*B);
    }
}
