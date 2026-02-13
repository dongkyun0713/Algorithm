package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2470 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        int i = 0;
        int j = N - 1;
        int prior = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        while (i < j) {
            int left = arr[i];
            int right = arr[j];
            int sum = left + right;
            if (Math.abs(sum) < Math.abs(prior)) {
                a = left;
                b = right;
                prior = sum;
            }
            if (sum > 0) j--;
            else if (sum == 0) break;
            else i++;
        }
        System.out.println(a + " " + b);

    }
}
