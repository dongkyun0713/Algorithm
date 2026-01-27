package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 {
    static int N;
    static int[] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i;

            if (possibility(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean possibility(int depth) {
        for (int i = 0; i < depth; i++) {
            if (board[depth] == board[i]) {
                return false;
            } else if (Math.abs(depth - i) == Math.abs(board[depth] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
