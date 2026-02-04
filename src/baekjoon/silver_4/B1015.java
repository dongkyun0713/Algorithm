package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1015 {
    static class Arr {
        int index;
        int value;

        Arr(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Arr[] A = new Arr[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = new Arr(i, Integer.parseInt(st.nextToken()));
        }
        int[] P = new int[N];

        Arrays.sort(A, (a,b) -> {
            if (a.value != b.value) return a.value - b.value;
            return a.index - b.index;
        });

        for (int i = 0; i < N; i++) {
            P[A[i].index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int p : P) {
            sb.append(p).append(" ");
        }
        System.out.println(sb);

    }
}
