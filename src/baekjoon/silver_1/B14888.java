package baekjoon.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
    static int N;
    static int[] op;
    static int[] num;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, num[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int idx, int result) {
        if (idx == N-1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        int next = num[idx+1];
        for (int j = 0; j < 4; j++) {
            if (op[j] > 0) {
                op[j]--;
                if (j == 0) {
                    dfs(idx + 1, result + next);
                } else if (j == 1) {
                    dfs(idx + 1, result - next);
                } else if (j == 2) {
                    dfs(idx + 1, result * next);
                } else {
                    dfs(idx + 1, result / next);
                }
                op[j]++;
            }
        }

    }
}
