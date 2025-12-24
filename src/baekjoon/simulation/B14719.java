package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];  // 0: 아무것도 없음, 1: 블록

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int block = Integer.parseInt(st.nextToken());
            for (int j = 0; j < block; j++) {
                arr[j][i] = 1;
            }
        }
        int count = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == 1) {
                    int temCount = 0;
                    for (int k = j + 1; k < w; k++) {
                        if (arr[i][k] == 1) {
                            count += temCount;
                            break;
                        }
                        ++temCount;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
