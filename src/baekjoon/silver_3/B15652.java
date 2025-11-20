package baekjoon.silver_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class B15652 {
    static int N, M;
    static List<Integer> selected = new ArrayList<>();
    static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        dfs(1, N);
        wr.close();
    }

    private static void dfs(int from, int to) throws IOException {
        if (selected.size() == M) {
            for (int i : selected) {
                wr.write(i + " ");
            }
            wr.write("\n");
            return;
        }

        for (int i = from; i <= to; i++) {
            selected.add(i);
            dfs(i, to);
            selected.remove(selected.size() - 1);
        }
    }
}
