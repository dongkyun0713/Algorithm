package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2661 {
    static int N;
    static char[] arr;
    static boolean done = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (done) return;
        if (depth == N) {
            System.out.print(new String(arr));
            done = true;
            return;
        }
        for (char c = '1'; c <= '3'; c++) {
            arr[depth] = c;
            if (isGood(depth + 1)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isGood(int len) {
        for (int i = 1; i <= len / 2; i++) {
            boolean same = true;
            for (int j = 0; j < i; j++) {
                if (arr[len - 1 - j] != arr[len - 1 - j - i]) {
                    same = false;
                    break;
                }
            }
            if (same) return false;
        }
        return true;
    }
}
