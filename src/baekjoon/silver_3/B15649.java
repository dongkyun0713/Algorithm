package baekjoon.silver_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class B15649 {
    static int N, M;
    static List<Integer> selected = new ArrayList<>();
    static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        dfs();
        wr.close();

    }

    private static void dfs() throws IOException {
        if (selected.size() == M) {
            for (int k : selected) {
                wr.write(k + " ");
            }
            wr.write("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!selected.contains(i)) {
                selected.add(i);
                dfs();
                selected.remove(selected.size() - 1);
            }
        }

    }
}
