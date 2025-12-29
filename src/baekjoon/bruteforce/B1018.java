package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 열
        int M = Integer.parseInt(st.nextToken());  // 행

        char[][] board = new char[N][M];
        for (int r = 0; r < N; r++) {
            board[r] = br.readLine().toCharArray();
        }

        int answer = Integer.MAX_VALUE;


        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cntW = 0; 
                int cntB = 0;

                for (int r = i; r < i + 8; r++) {
                    for (int c = j; c < j + 8; c++) {
                        int index = (r - i + c - j) % 2;

                        char expectedW = (index == 0) ? 'W' : 'B';
                        char expectedB = (index == 0) ? 'B' : 'W';

                        if (expectedW != board[r][c]) ++cntW;
                        if (expectedB != board[r][c]) ++cntB;
                    }
                }
                answer = Math.min(answer, Math.min(cntW, cntB));
            }
        }
        System.out.println(answer);
    }
}
