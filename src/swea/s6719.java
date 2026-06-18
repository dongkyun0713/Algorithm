package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s6719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] M = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                M[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(M);
            double sum = 0;
            for (int i = N-K; i < N; i++) {
                sum = (sum + M[i]) / 2;
            }

            sb.append('#').append(t).append(' ').append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
