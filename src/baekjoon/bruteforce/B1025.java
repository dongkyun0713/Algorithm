package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1025 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int answer = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int dr = -N; dr <= N; dr++) {
                    for (int dc = -M; dc <= M; dc++) {
                        if (dr == 0 && dc == 0) {
                            continue;
                        }
                        int r = i;
                        int c = j;
                        int num = 0;
                        while (r >= 0 && r < N && c >= 0 && c < M) {
                            num = num * 10 + arr[r][c];
                            if (isSquare(num)) {
                                answer = Math.max(answer, num);
                            }
                            r += dr;
                            c += dc;
                        }

                    }
                }
            }
        }
        System.out.println(answer);
    }

    static boolean isSquare(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }
}
