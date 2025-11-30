package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11054 {
    static int n;
    static int[] seq;
    static int[] incMemo;
    static int[] decMemo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        seq = new int[n];
        incMemo = new int[n];
        decMemo = new int[n];

        Arrays.fill(incMemo, -1);
        Arrays.fill(decMemo, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int inc = dfsInc(i);
            int dec = dfsDec(i);

            answer = Math.max(answer, inc + dec -1);
        }
        System.out.println(answer);

    }

    private static int dfsInc(int end) {
        if (incMemo[end] != -1) {
            return incMemo[end];
        }
        int result = 1;
        for (int i = 0; i < end; i++) {
            if (seq[end] > seq[i]) {
                result = Math.max(result, dfsInc(i) + 1);
            }
        }
        return incMemo[end] = result;
    }

    private static int dfsDec(int start) {
        if (decMemo[start] != -1) {
            return decMemo[start];
        }
        int result = 1;
        for (int i = start + 1; i < n; i++) {
            if (seq[start] > seq[i]) {
                result = Math.max(result, dfsDec(i) + 1);
            }
        }
        return decMemo[start] = result;
    }
}
