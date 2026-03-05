package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
    static int N;
    static int[] arr;
    static int[] op;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static private void dfs(int depth, int result) {
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                if (i == 0) {
                    dfs(depth + 1, result + arr[depth]);
                } else if (i == 1) {
                    dfs(depth + 1, result - arr[depth]);
                } else if (i == 2) {
                    dfs(depth + 1, result * arr[depth]);
                } else {
                    dfs(depth + 1, result / arr[depth]);
                }
                op[i]++;
            }
        }


    }
}
