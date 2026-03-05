package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B5582 {
    static String s1, s2;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();

        int n = s1.length();
        int m = s2.length();

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

    }


}
