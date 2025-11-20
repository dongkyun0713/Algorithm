package baekjoon.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;

public class B2776 {
    static int T, N, M;
    static Set<Integer> note1;

    public static void main(String[] args) throws IOException {
        var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        tk.nextToken();
        T = (int) tk.nval;

        for (int t = 0; t < T; t++) {
            tk.nextToken();
            N = (int) tk.nval;
            note1 = new HashSet<>();
            for (int i = 0; i < N; i++) {
                tk.nextToken();
                note1.add((int) tk.nval);
            }
            tk.nextToken();
            M = (int) tk.nval;
            for (int i = 0; i < M; i++) {
                tk.nextToken();
                int num = (int) tk.nval;
                if (note1.contains(num)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
