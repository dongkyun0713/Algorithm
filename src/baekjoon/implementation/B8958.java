package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char[] quiz = br.readLine().toCharArray();
            int[] points = new int[quiz.length];
            points[0] = quiz[0] == 'O' ? 1 : 0;

            for (int j = 1; j < quiz.length; j++) {
                if (quiz[j] == 'O') points[j] += points[j-1] + 1;
            }

            int answer = 0;
            for (int k : points) {
                answer += k;
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
