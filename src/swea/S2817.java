package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2817 {
    static int cnt;
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);

            sb.append('#').append(i).append(' ').append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int idx, int sum) {
        if (sum > K) return;
        if (idx == N) {
            if (sum == K) {
                cnt++;
            }
            return;
        }
        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}
