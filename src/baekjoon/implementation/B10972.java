package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int i;
        for (i = N - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }

        if (i == 0) {
            System.out.println(-1);
            return;
        }

        int j;
        for (j = N - 1; j >= i; j--) {
            if (arr[j] > arr[i - 1]) {
                break;
            }
        }

        swap(arr, i-1, j);
        Arrays.sort(arr, i, N);

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < N; k++) {
            sb.append(arr[k]).append(" ");
        }

        System.out.print(sb);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
