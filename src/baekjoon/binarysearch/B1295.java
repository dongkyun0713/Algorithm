package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            set.add(n);
        }
        Arrays.sort(arr);
        int cnt = 0;
        int i = 0;
        int j = N;


    }
}
