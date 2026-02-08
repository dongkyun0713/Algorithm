package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1058 {
    static int N;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            boolean[] isFriend = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (arr[i][j] == 'Y') {
                    isFriend[j] = true;
                } else {
                    for (int k = 0; k < N; k++) {
                        if (arr[i][k] == 'Y' && arr[k][j] == 'Y') {
                            isFriend[j] = true;
                            break;
                        }
                    }
                }

            }
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (isFriend[j]) cnt++;
            }
            max = Math.max(max, cnt);
        }


        System.out.println(max);
    }

}
