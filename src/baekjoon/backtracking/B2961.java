package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961 {
    static int N, answer;
    static int[] S;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MAX_VALUE;

        dfs(0, 1, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int idx, int s, int b, int cnt) {
        if (idx == N) {
            if (cnt == 0) {
                return;
            }
            answer = Math.min(answer, Math.abs(s - b));
            return;
        }
        dfs(idx + 1, s * S[idx], b + B[idx], cnt + 1);
        dfs(idx + 1, s, b, cnt);
    }
}
