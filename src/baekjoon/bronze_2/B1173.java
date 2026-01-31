package baekjoon.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //  N, m, M, T, R
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int time = 0;
        int exerciseTime  = 0;
        int pulse = m;
        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        while (exerciseTime != N) {
            if (pulse + T <= M) {
                pulse += T;
                exerciseTime++;
                time++;
            } else {
                if (pulse - R < m ) pulse = m;
                else pulse -= R;
                time++;
            }
        }
        System.out.println(time);
    }
}
