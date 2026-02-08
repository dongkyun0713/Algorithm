package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20950 {
    static int N;
    static int[][] colors;
    static int[] rgbGom = new int[3];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colors = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        rgbGom[0] = Integer.parseInt(st.nextToken());
        rgbGom[1] = Integer.parseInt(st.nextToken());
        rgbGom[2] = Integer.parseInt(st.nextToken());
        dfs(0, 0, 0, 0, 0);
        System.out.println(answer);

    }

    private static void dfs(int index, int count, int redSum, int greenSum, int blueSum) {
        if (count == 7 || index == N) {
            if (count >= 2) {
                answer = Math.min(answer, calc(count, redSum, greenSum, blueSum));
            }
            return;
        }

        dfs(index + 1, count + 1, redSum + colors[index][0], greenSum + colors[index][1],
                blueSum + colors[index][2]);
        dfs(index + 1, count, redSum, greenSum, blueSum);

    }

    private static int calc(int count, int redSum, int greenSum, int blueSum) {
        return Math.abs(rgbGom[0] - redSum / count) + Math.abs(rgbGom[1] - greenSum / count) + Math.abs(
                rgbGom[2] - blueSum / count);
    }

}
