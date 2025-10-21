package baekjoon.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B15654 {
    static int N, M;
    static int[] A;
    static List<Integer> selected = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void dfs() throws IOException {
        if (selected.size() == M) {
            for (int i : selected) {
                sb.append(A[i]).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 0; i < N; i++) {
            if (!selected.contains(i)) {
                selected.add(i);
                dfs();
                selected.remove(selected.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        dfs();
        System.out.println(sb);

    }
}
