package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B1026_보물 {
    static int n;
    static Integer[] a, b;
    static int[] order;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        a = new Integer[n];
        b = new Integer[n];
        order = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input1[i]);
            b[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            answer += a[i] * b[i];
        }
        System.out.println(answer);
    }
}
