package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B12933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] correct = {'q', 'u', 'a', 'c', 'k'};
        boolean[] visited = new boolean[input.length];
        int visitCount = 0;
        int ducks = 0;

        for (int i = 0; i < input.length; i++) {
            if (visited[i]) continue;
            if (input[i] != 'q') continue;

            ducks++;
            int correctIdx = 0;
            boolean correctSound = false;

            for (int j = i; j < input.length; j++) {
                if (visited[j]) continue;
                if (correct[correctIdx] == input[j]) {
                    visited[j] = true;
                    correctIdx++;
                    visitCount++;
                }

                if (correctIdx == 5) {
                    correctIdx = 0;
                    correctSound = true;
                }
            }

            if (!correctSound || correctIdx != 0) {
                System.out.println(-1);
                return;
            }
        }

        if (visitCount != input.length) {
            System.out.println(-1);
        } else {
            System.out.println(ducks);
        }
    }
}
