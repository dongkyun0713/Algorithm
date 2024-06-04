package silver_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1018_체스판다시칠하기 {
    static int n, m;
    static int countW = 0, countB = 0, answer = 0;

    static String[][] board = new String[n][m];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            countB += countChar(s, 'B');
            countW += countChar(s, 'W');

            String[] arr = s.split("");
            board[i] = arr;
        }

        if (countW > countB) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                }

            }
        }
    }

    public static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
}
