package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889 {
    static int N;
    static int[][] arr;
    static int answer;
    static boolean[] pick;  // true는 start 팀, false는 link 팀

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;

        pick = new boolean[N];
        pick[0] = true;

        dfs(1, 1);
        System.out.println(answer);

    }

    private static void dfs(int idx, int cnt) {
        if (cnt == N / 2) {
            int start = 0, link = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (pick[i] && pick[j]) {
                        start += arr[i][j] + arr[j][i];
                    } else if (!pick[i] && !pick[j]) {
                        link += arr[i][j] + arr[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(start - link));
            return;
        }



        if (idx == N) {
            return;
        }

        pick[idx] = true;
        dfs(idx + 1, cnt + 1);

        pick[idx] = false;
        dfs(idx + 1, cnt);
    }
}
