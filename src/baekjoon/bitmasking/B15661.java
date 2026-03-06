package baekjoon.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15661 {
    static int N;
    static int[][] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        int fullMast = (1 << N) - 1; // N개의 1

        for (int mask = 1; mask < fullMast; mask++) {
            if ((mask & 1) == 0) continue; // 0번 사람 스타트 팀 고정

            int startScore = 0;
            int linkScore = 0;

            for (int i = 0; i < N; i++) {
                boolean iIsStart = (mask & (1 << i)) != 0;
                for (int j = i+1; j < N; j++) {
                    boolean jIsStart = (mask & (1 << j)) != 0;

                    if (iIsStart && jIsStart) {
                        startScore += S[i][j] + S[j][i];
                    } else if (!iIsStart && !jIsStart) {
                        linkScore += S[i][j] + S[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(startScore - linkScore));
        }
        System.out.println(answer);
    }
}
