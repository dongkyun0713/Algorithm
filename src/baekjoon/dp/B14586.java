package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B14586 {
    static int N;
    static Domino[] dominoes;
    static int[] memo;
    static int[] reachR;
    static int[] reachL;

    private static class Domino {
        long x;
        long h;

        Domino(long x, long h) {
            this.x = x;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        dominoes = new Domino[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            dominoes[i] = new Domino(x, h);
        }

        Arrays.sort(dominoes, Comparator.comparingLong(d -> d.x));

        reachR = new int[N];
        for (int i = 0; i < N; i++) {
            long end = dominoes[i].x + dominoes[i].h;
            int j = i;

            while (j + 1 < N && dominoes[j + 1].x <= end) {
                j++;
                end = Math.max(end, dominoes[j].x + dominoes[j].h);
            }
            reachR[i] = j;
        }

        reachL = new int[N];
        for (int i = 0; i < N; i++) {
            long start = dominoes[i].x - dominoes[i].h;
            int j = i;

            while (j - 1 >= 0 && dominoes[j - 1].x >= start) {
                j--;
                start = Math.min(start, dominoes[j].x - dominoes[j].h);
            }
            reachL[i] = j;
        }

        memo = new int[N];
        Arrays.fill(memo, -1);

        System.out.println(dfs(N - 1));
    }

    // 0~index 도미노까지 모두 넘어뜨리기 위한 최소 횟수
    private static int dfs(int index) {
        if (index < 0) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }

        // 왼쪽으로 밀기
        int best = 1 + dfs(reachL[index] - 1);

        // 오른쪽으로 밀기
        for (int i = 0; i <= index; i++) {
            if (reachR[i] >= index) {
                best = Math.min(best, dfs(i - 1) + 1);
            }
        }

        return memo[index] = best;
    }
}
