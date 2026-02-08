package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class B2352 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] tails = new int[n];
        int len = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            int pos = Arrays.binarySearch(tails, 0, len, x);
            if (pos < 0) {
                pos = -pos - 1;
            }

            tails[pos] = x;
            if (pos == len) {
                len++;
            }
        }

        System.out.println(len);
    }
}
